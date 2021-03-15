//Орёл Маргарита 10а
//Площадь выпуклого многоугольника

import java.util.Scanner;

public class Fifth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// количество вершин
		int N = sc.nextInt();
		double[][] points = new double[N][2];
		// координаты вершин
		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}
		sc.close();

		double[] double_squares = new double[N - 2];

		
		double x1 = points[0][0];
		double y1 = points[0][1];
		
		for (int i = 1; i < N - 1; i++) {
			double x2 = points[i][0];
			double y2 = points[i][1];
			double x3 = points[i+1][0];
			double y3 = points[i+1][1];
			
			double_squares[i-1] = x1*y2 - x2*y1 +
								x2*y3 - x3*y2 +
								x3*y1 - x1*y3;
		}
		
		double double_size = 0;
		
		for(int i = 0; i < double_squares.length; i++) {
			double_size = double_size + double_squares[i];
		}
		
		System.out.print(Math.abs(double_size/2));
	}

}
