import java.util.Scanner;

public class First1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		int n = sc.nextInt();
		double[][] points = new double[n][2];
		
		for (int i = 0; i < n; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}
		sc.close();

		double x2_new = x2 - x1;
		double y2_new = y2 - y1;
		for (int i = 0; i < n; i++) {
			points[i][0] = points[i][0] - x1;
			points[i][1] = points[i][1] - y1;
		}

		boolean flag = true;
		double p0 = points[0][0] * y2_new - x2_new * points[0][1];
		for (int i = 1; i < n; i++) {
			double p_this = points[i][0] * y2_new - x2_new * points[i][1];
			if (p0 * p_this < 0) {
				flag = false;
				break;
			}
		}

		if (flag == true)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}
