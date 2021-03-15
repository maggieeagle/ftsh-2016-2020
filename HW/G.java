import java.util.Scanner;

//Oryol_Margarit
//G

public class G {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); //timber_length
		int N = sc.nextInt(); //number of cuts
		int[] cuts = new int[N + 2];
		
		cuts[0] = 0;
		for(int i = 1; i < N + 1; i++) {
			cuts[i] = sc.nextInt();
		}
		cuts[N+1] = L;
		
		int[][] a = new int[N+2][N+2];
		
		for(int j = 2; j < N+2; j++) {
			for(int i = 0; i < N + 2 - j; i++) {
				
				int min = 10000000;
				for(int k = i+1; k < i+j; k++) {
					min = Math.min(a[i][k] + a[k][i+j], min);
				}
				a[i][i + j] = cuts[i + j] - cuts[i] + min;
			}
		}
		
		/*for(int i = 0; i < N + 2; i++) {
			for(int j = 0; j < N+2; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.print(a[0][N+1]);
	}
}
