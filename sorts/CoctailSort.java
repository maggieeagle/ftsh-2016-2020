import java.util.Scanner;
import java.util.Random;

public class CoctailSort {

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
				for (int j = 0; j < (arr.length - 1) / 2; j++) {
					int tmp = 0;
					int flag = 0;
					for (int i = 0; i < arr.length - j - 1; i++) {
						if (arr[i] > arr[i + 1]) {
							tmp = arr[i + 1];
							arr[i + 1] = arr[i];
							arr[i] = tmp;
							flag = 1;
						}
					}
					if (flag == 0) {
						break;
					}
					for (int i = arr.length - j - 2; i > -1; i--) {
						if (arr[i] > arr[i + 1]) {
							tmp = arr[i];
							arr[i] = arr[i + 1];
							arr[i + 1] = tmp;
							flag = 1;
						}
					}
					if (flag == 0) {
						break;
					}
				}
				long t2 = System.currentTimeMillis();
				long t = t2 - t1;
				arr_time[n] = t;
			}
			System.out.println(size + "\t" + (arr_time[0] + arr_time[1] + arr_time[2] + arr_time[3] + arr_time[4]) / 5);
			sc.close();
		}
		System.out.print("That's all");
	}
}
