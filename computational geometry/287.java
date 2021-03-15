import java.util.ArrayList;
import java.util.Scanner;

//Oryol Margarita
//informatics 287

public class C {
	public static class point {
		int x, y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int side(point one, point two, point S) {
		double tmp = (two.x - one.x) * (S.y - two.y) - (two.y - one.y) * (S.x - two.x);
		if (tmp > 0)
			return 1; // left
		if (tmp < 0)
			return -1;// right
		return 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		point points[] = new point[N];

		for (int i = 0; i < N; i++) {
			points[i] = new point(sc.nextInt(), sc.nextInt());
		}

		boolean flag = true;
		int prev = side(points[0], points[1], points[2]);

		for (int i = 0; i < N; i++) {
			int next = (i + 1)%N;

			for (int j = 0; j < N; j++) {
				if (side(points[i], points[next], points[j]) != prev && side(points[i], points[next], points[j]) != 0) {
					flag = false;
					break;
				}
			}

		}

		if (flag == true)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}
