import java.util.Scanner;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		for (int w = 0; w < 100001; w = w + 5000) {
			Scanner sc = new Scanner(System.in);
			int size = w;
			int arr[] = new int[size];
			long arr_time[] = new long[5];
			Random r = new Random();
			for (int k = 0; k < size; k++) {
				arr[k] = r.nextInt(1000000);
			}
			int arr_copy[] = new int[size];
			for (int n = 0; n < 5; n++) {
				for (int k = 0; k < size; k++) {
					arr_copy[k] = arr[k];
				}
				long t1 = System.currentTimeMillis();
				for (int j = size - 1; j >= 0; j--) {
					int maxNum = 0;
					for (int i = 1; i <= j; i++) {
						if (arr[i] > arr[maxNum]) {
							maxNum = i;
						}
						int tmp = arr[j];
						arr[j] = arr[maxNum];
						arr[maxNum] = tmp;
					}
				}
				long t2 = System.currentTimeMillis();
				long t = t2 - t1;
				arr_time[n] = t;
			}
			System.out
					.println(size
							+ "\t"
							+ (arr_time[0] + arr_time[1] + arr_time[2]
									+ arr_time[3] + arr_time[4]) / 5);
			sc.close();
		}
		System.out.print("That's all");
	}
}
