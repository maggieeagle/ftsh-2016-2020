//Oryol Margarita
//Jarvis
//convex hull

import java.util.ArrayList;
import java.util.Scanner;

class EJarvis {
	public static int sq(point one, point two, point three) {
		int sq = (two.y - one.y) * (three.x - two.x) - (two.x - one.x) * (three.y - two.y);

		if (sq == 0) {
			return 0;
		}
		if (sq > 0)
			return 1;
		return 2;
	}
	
	public static double length(point p1, point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
	}
	
	public static double square(point one, point two, point three) {
		double tmp = Math.abs((double)((two.x - one.x) * (three.y - one.y) - (two.y - one.y) * (three.x - one.x))/2);
		return tmp;
	}
	
	public static class point {
		int x, y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		point[] points = new point[N];
		ArrayList<point> shell = new ArrayList<point>();

		for (int i = 0; i < N; i++) {
			points[i] = new point(sc.nextInt(), sc.nextInt());
		}

		int l = 0;
		for (int i = 1; i < N; i++) {
			if (points[i].x < points[l].x) {
				l = i;
			}
		}

		int p = l, q;
		do {
			shell.add(points[p]);
			q = (p + 1) % N;

			for (int i = 0; i < N; i++) {
				if (sq(points[p], points[i], points[q]) == 2)
					q = i;
			}

			p = q;

		} while (p != l);
		
double perimetr = 0, square = 0;
		
		for(int i = 0; i < shell.size(); i++) {
			int next = i+1;
			if(next == shell.size()) next = 0;
			perimetr+=length(shell.get(i), shell.get(next));
			
			int nextnext = i+2;
			if(nextnext < shell.size()) {
				double d_sq = square(shell.get(0), shell.get(next), shell.get(nextnext));
				//System.out.println(d_sq);
				square+=d_sq;
			}
		}
		
		System.out.println(Math.abs(perimetr));
		System.out.println(Math.abs(square));
	}
}
