import java.util.Scanner;
// 셸 정렬

class ShellSort {
	//셸 정렬
	static void shellSort(int[] a, int n) {
		for (int h = n / 2; h > 0; h /= 2)    // 간격 설정
			for (int i = h; i < n; i++) {       // 삽입 정렬을 하기 위해 부분 배열의 두 번째 값을 가지고 비교
				int j;
				int tmp = a[i];                   // ex 간격이 4이면 처음 arr[i]는 7. 7 ~ 5까지 삽입 정렬 시작
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h)    // 부분 배열끼리 연산하도록 j = i - h
					a[j + h] = a[j];                               // 삽입 정렬을 위해 한칸 씩 미뤄줌
				a[j + h] = tmp;                                  // 조건문을 빠져나온 j는 이미 j-h 연산이 끝났으므로 다시 +h를 해줌 
			}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬(버전 1)");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		shellSort(x, nx);			// 배열 x를 셸 정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
