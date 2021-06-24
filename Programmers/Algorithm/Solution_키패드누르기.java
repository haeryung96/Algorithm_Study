
public class Solution_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String ans = solution(numbers, hand);
		System.out.println(ans);
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		// 아래의 두 좌표는 시작점의 위치 
		int l_start = 10; // 키패드 *
		int r_start = 12; // 키패드 #
		
		int L_dis, R_dis; // 왼쪽 거리, 오른쪽 거리 
		
		for(int num : numbers) {
			L_dis = 0; // 왼쪽 거리 초기화
			R_dis = 0; // 오른쪽 거리 초기와 
			
			if(num == 1 || num == 4 || num == 7) { // 왼쪽 좌표의 경우 
				sb.append("L"); // 왼쪽으로 움직이기
				l_start = num;
			}
			else if(num == 3 || num == 6 || num == 9) { // 오른쪽 좌표의 경우 
				sb.append("R");
				r_start = num;
			}
			else { // 2,5,8,0 인 경우 
				if(num == 0) { // 키패드의 좌표가 10과 12 사이에 0
					num += 11;
				}
				L_dis = (Math.abs(num - l_start))/3 + (Math.abs(num - l_start))%3;
				R_dis = (Math.abs(r_start - num))/3 + (Math.abs(r_start - num))%3;
				if(L_dis == R_dis) {
					if(hand.equals("left")) {
						sb.append("L");
						l_start = num; 
					}
					else {
						sb.append("R");
						r_start = num;
					}
				}
				else if(R_dis > L_dis) {
					sb.append("L");
					l_start = num;
				}
				else if(L_dis > R_dis) {
					sb.append("R");
					r_start = num;
				}
			}
		}
        return sb.toString();
	}
}
