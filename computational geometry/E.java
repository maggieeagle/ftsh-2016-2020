import java.util.Scanner;

//Oryol Margarita 10a
//E
public class E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		double[][] points = new double[N][2];

		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextDouble();
			points[i][1] = sc.nextDouble();
		}
		
		int min_number = 0;
		for(int i = 0; i < N; i++) {
			if(points[i][0] < points[min_number][0]) min_number = i;
			if(points[i][0] == points[min_number][0] &&
			   points[i][1] < points[min_number][1]) min_number = i;
			System.out.print(min_number);
		}

	}
}
