import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double P = sc.nextDouble(); // bear
		double Hp = sc.nextDouble();
		double S = sc.nextDouble(); // ball
		double Hs = sc.nextDouble();

		if (P == S)
			System.out.print(P);
		else {
			double not_target, target, dr;
			
			double min;
			if (P > S) {
				target = Hs;
				not_target = Hp;
				dr = P - S;
				min = S;
			} else {
				target = Hp;
				not_target = Hs;
				dr = S - P;
				min = P;
			}

			//tangent line
			double b = dr / (not_target - target);
			double a = Math.sqrt(1 - b * b);
			double c = min - b * target;
			
			//symmetrical tangent line
			double as = -a;
			double bs = b;
			double cs = c;
			
			double cross_y = (a*cs-c*as)/(b*as-a*bs);
			
			if(cross_y < Hp-P && cross_y >= 0) System.out.print(0);
			else System.out.print((double)Math.abs(c/a));
			

			// System.out.print(l);
		}

	}

}
