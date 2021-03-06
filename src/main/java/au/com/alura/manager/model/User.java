package au.com.alura.manager.model;

public class User {

	 private String login;
	    private String password;

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String senha) {
	        this.password = senha;
	    }

	    public boolean isEqual(String login, String senha) {
	        if(!this.login.equals(login)) {
	            return false;
	        }

	        if(!this.password.equals(senha)) {
	            return false;
	        }

	        return true;
	    }
	
}
