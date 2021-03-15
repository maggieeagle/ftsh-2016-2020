import java.util.Scanner;

//Oryol Margarita
//does a point belong to the convex polygon?

public class D{

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
		
		boolean flag = false;
		
		for(int i = 0, j = N-1; i < N; j=i++) {
			
			if((points[i][1] > y0)!=(points[j][1] > y0) && (x0 < (points[j][0] - points[i][0])*(y0 - points[i][1])/(points[j][1] - points[i][1]) + points[i][0])){
						flag=!flag;
					}
		}
		
		if(flag == true) System.out.print("YES");
		else System.out.print("NO");
	}
}
