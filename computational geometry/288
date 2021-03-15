//informatics 288

import java.util.Scanner;

public class Bnew2{
	
	public static class point {
		int x, y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static double angle(point one, point two) {
		return Math.atan2(one.x*two.y-one.y*two.x, one.x*two.x + one.y*two.y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		point point = new point(sc.nextInt(), sc.nextInt());
		
		point points[] = new point[N];

		for (int i = 0; i < N; i++) {
			points[i] = new point(sc.nextInt() - point.x, sc.nextInt() - point.y);
		}
		
		double a = 180*(N-2);
		double summ_angle = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			int next = (i + 1)%N;
			
			point one = points[i];
			point two = points[next];
			double tmp1 = one.x*two.y-one.y*two.x;
			double tmp2 = one.x*two.x + one.y*two.y;
			//double a2 = angle(points[next], points[i]);
			if(tmp1==0) {
				flag = true;
				break;
			}
			summ_angle+=Math.atan2(tmp1, tmp2);
			//System.out.println(a1 + " ");
		}
		
		//System.out.println(summ_angle + " " + a);
		
		if(Math.abs(summ_angle) >= 0.000001) flag = true;
		if(flag==true)System.out.print("YES");
		else System.out.print("NO");
		
		sc.close();
		
		
	}
}
