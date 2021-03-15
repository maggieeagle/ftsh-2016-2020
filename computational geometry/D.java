import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		double[][] points = new double[N][2];

		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}

		double x0 = sc.nextDouble();
		double y0 = sc.nextDouble();

		sc.close();

		boolean flag1 = true;
		boolean flag2 = true;

		for (int i = 0; i < N; i++) {

			int i2 = 0;
			if (i == N - 1)
				i2 = 0;
			else
				i2 = i + 1;

			double x0_new = x0 - points[i][0];
			double y0_new = y0 - points[i][1];
			double xi2_new = points[i2][0] - points[i][0];
			double yi2_new = points[i2][1] - points[i][1];

			double cos = x0_new * yi2_new - xi2_new * y0_new;

			if (cos <= 0)
				flag1 = false;
			if (cos >= 0)
				flag2 = false;
		}

		if (flag1 == true || flag2 == true)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}