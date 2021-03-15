
//Орёл Маргарита 10а
//Образуют ли точки выпуклый многоугольник?

import java.util.Scanner;

public class First2 {

	static int N;
	static double[][] points;

	public static boolean check(int number1, int number2, double x1, double y1, double x2, double y2) {

		boolean flag = true;
		double[][] points2 = points;

		// перенесем начало координат в точку (x1, y1)
		double x2_new = x2 - x1;
		double y2_new = y2 - y1;
		for (int i = 0; i < N; i++) {
			points2[i][0] = points2[i][0] - x1;
			points2[i][1] = points2[i][1] - y1;
		}

		double p0 = points2[0][0] * y2_new - x2_new * points2[0][1];
		for (int i = 1; i < N; i++) {
			if (i == number1 || i == number2)
				continue;
			double p_this = points2[i][0] * y2_new - x2_new * points2[i][1];
			if (p0 * p_this < 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// количество точек
		N = sc.nextInt();
		points = new double[N][2];
		// координаты точек
		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}
		sc.close();

		boolean flag2 = true;
		for (int i = 0; i < N; i++) {
			
			int i2 = 0;
			if(i == N-1) i2 = 0;
			else i2=i+1;
			
			if (check(i, i2, points[i][0], points[i][1], points[i2][0], points[i2][1]) == false) {
				flag2 = false;
				break;
			}
		}

		if (flag2 == true)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}
