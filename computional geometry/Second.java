//Орёл Маргарита 10а
//Расстояние от точки до отрезка

import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// точка
		double x0 = sc.nextDouble();
		double y0 = sc.nextDouble();
		// две точки, задающие отрезок
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		sc.close();

		// перенесем начало координат в точку (x0, y0)
		double x1_new = x1 - x0;
		double y1_new = y1 - y0;
		double x2_new = x2 - x0;
		double y2_new = y2 - y0;

		// уравнение прямой, содержащей отрезок
		double a = y2_new - y1_new;
		double b = x1_new - x2_new;
		double c = x1_new * y2_new - x2_new * y1_new;

		// расстояние от точки до прямой, содержащей отрезок
		double l = c / Math.sqrt(a * a + b * b);

		// перенесем начало координат в точку (x1, y1)
		double x0_new = x0 - x1;
		double y0_new = y0 - y1;
		x2_new = x2 - x1;
		y2_new = y2 - y1;

		double scalar1 = x2_new * x0_new + y2_new * y0_new;

		// перенесем начало координат в точку (x2, y2)
		x0_new = x0 - x2;
		y0_new = y0 - y2;
		x1_new = x1 - x2;
		y1_new = y1 - y2;

		double scalar2 = x1_new * x0_new + y1_new * y0_new;

		double dist;
		if(scalar1 >= 0 && scalar2 >= 0) dist = l;
		else dist = Math.sqrt(Math.min((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1),
				(x0-x2)*(x0-x2) + (y0-y2)*(y0-y2)));
		
		System.out.print(dist);
		
	}
}