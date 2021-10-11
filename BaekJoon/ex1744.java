import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex1744 {
   static int N;
   static ArrayList<Integer> negative = new ArrayList<>();
   static ArrayList<Integer> positive = new ArrayList<>();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      
      for(int i=0; i < N; i++) {
         int num = Integer.parseInt(br.readLine());
         
         if(num <= 0) {
            negative.add(num);
         }
         else {
            positive.add(num);
         }
      }
      
      Collections.sort(negative);
      Collections.sort(positive);
      
      int sum = 0;
      
      // 음수의 개수가 짝수일 때 
      // 음수는 무조건 더하기 (0포함)
      if(negative.size() % 2 == 0) {
         for(int i = 0; i <= negative.size() - 1; i+=2) {
            sum += (negative.get(i) * negative.get(i+1));
         }
      }
      else {
    	for(int i = 0; i <= negative.size() - 2; i+=2) {
    	      sum += (negative.get(i) * negative.get(i+1));
    	}
    	
    	sum += negative.get(negative.size() - 1);
      }
      
      // 양수의 개수가 짝수일 때
      // 양수는 무조건 곱하기 - 1제외
      if(positive.size() % 2 == 0) {
         for(int i = positive.size() - 1; i >= 0; i-=2) {
            if(positive.get(i) == 1 || positive.get(i-1) == 1) {
               sum += (positive.get(i) + positive.get(i-1));
            }
            else {
                sum += (positive.get(i) * positive.get(i-1));
             }
         }
      }
      else {
         for(int i = positive.size() - 1; i >= 1; i-=2) {
            if(positive.get(i) == 1 || positive.get(i-1) == 1) {
               sum += (positive.get(i) + positive.get(i-1));
            }
            else {
               sum += (positive.get(i) * positive.get(i-1));
            }
         }
         
         sum += positive.get(0); // 마지막 작은 수는 더하기 
      }
      
      System.out.println(sum);
   }

}
