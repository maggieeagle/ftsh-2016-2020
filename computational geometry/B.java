import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		double x0 = sc.nextDouble();
		double y0 = sc.nextDouble();

		double[][] points = new double[N][2];

		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}
		sc.close();
		
		double summ = 0;

		for (int i = 0; i < N; i++) {

			int i2 = 0;
			if (i == N - 1)
				i2 = 0;
			else
				i2 = i + 1;

			double xi_new = points[i][0] - x0;
			double yi_new = points[i][1] - y0;
			double xi2_new = points[i2][0] - x0;
			double yi2_new = points[i2][1] - y0;

			double tg = Math.atan2(xi_new*yi2_new - xi2_new*yi_new, 
								   xi_new*xi2_new + yi_new*yi2_new);

			summ = summ+tg;
		}

		if (summ==0)
			System.out.print("NO");
		else
			System.out.print("YES");
	}
}