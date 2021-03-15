
//Oryol Margarita
//E

import java.util.Scanner;

public class E3 {

	static char[] string;
	static int[][] a;
	static int k;

	public static int func(int l, int r) {
		if (r < l)
			return -1;
		if (l == r)
			return 1;
		if (string[l] == string[r])
			return func(l + 1, r - 1);
		int tmp = a[l][r];
		if (tmp != -1)
			return tmp;
		//if (func(l + 1, r - 1) + 1 <= k)
			return tmp = func(l + 1, r - 1) + 1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		k = sc.nextInt();
		int number = 0;

		String str = sc.next();
		string = new char[n];

		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++){
			a[i][j] = -1;
			}
		}

		sc.close();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (func(i, j) != -1)
					number++;
			}
		}

		System.out.print(number + n);
	}

}