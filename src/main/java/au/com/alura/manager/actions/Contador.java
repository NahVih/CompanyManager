package au.com.alura.manager.actions;

import java.util.ArrayList;
import java.util.List;

public class Contador {
	
static List<String> related = new ArrayList<String>();


public static int countGroups(List<String> related) {
    int count = 0;
    for(int i = 0; i < related.size(); i++){
        for(int j = 0; j < related.size(); j++){
            if(i == j){
                continue;
            } else {
                if ((related.get(i).equals("1")) && (related.get(j).equals("1"))) {
                    count++;
                }
            }
        }
    }
    return count;
// Write your code here

}

public static void main(String[] args) {
	
	Contador test = new Contador();
	test.related.add("1100");
	test.related.add("1110");
	test.related.add("0110"); 
	test.related.add("0001"); 
	
	test.countGroups(test.related);
	
}
	
	

}
