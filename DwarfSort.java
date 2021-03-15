import java.util.Scanner;
import java.util.Random;

public class DwarfSort {

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
				for (int j = 0; j < size - 1; j++) {
					int num = j + 1;
					while (num > 0) {
						if (arr[num] >= arr[num - 1]) {
							break;
						}
						int tmp = arr[num - 1];
						arr[num - 1] = arr[num];
						arr[num] = tmp;
						num--;
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