import java.util.*;

class Solution {
    public static ArrayList<String> strArr1 = new ArrayList<>();
    public static ArrayList<String> strArr2 = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        double answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i < str1.length()-1; i++){
            char firstJakade = str1.charAt(i);
            char secondJakade = str1.charAt(i+1);
            
            if('a' <= firstJakade && firstJakade <= 'z' &&
              'a' <= secondJakade && secondJakade <= 'z') {
                strArr1.add(firstJakade + "" + secondJakade);
            }
        }
        
        for(int i=0; i < str2.length()-1; i++){
            char firstJakade = str2.charAt(i);
            char secondJakade = str2.charAt(i+1);
            
            if('a' <= firstJakade && firstJakade <= 'z' &&
              'a' <= secondJakade && secondJakade <= 'z') {
                strArr2.add(firstJakade + "" + secondJakade);
            }
        }
        
        double intersect = 0; // 교집합
        double union = 0; // 합집합 
        
        for(int i=0; i < strArr1.size(); i++){
            if(strArr2.contains(strArr1.get(i))){
                intersect++;
                strArr2.remove(strArr1.get(i));
            }
            
            if(strArr2.isEmpty()){
                break;
            }
        }
                
        union = strArr1.size() + strArr2.size();

        System.out.println(intersect);
        System.out.println(union);
        
        if(union == 0){
            answer = 1;
        }
        else {
            answer = (intersect / union);
        }
        
        return (int)(answer * 65536);
    }
}
