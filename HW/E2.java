
//Oryol Margarita
//E

import java.util.Arrays;
import java.util.Scanner;

public class E2 {
	
	static char[] word;
	static int[][] a;
	static int count;
	
	public static int func(int l, int r) {
		int tmp = 0;
		if(l==r) return 0;
		if(l + 1 == r) {
			if(word[l]!=word[r]) return 1;
			else return 0;
		}
		//count = a[l][r];
		//if(count != -1) return count;
		if(word[l] == word[r]) {
			tmp = func(l+1, r-1);
			return tmp;
		}
		tmp = func(l+1, r-1) + 1;
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		count = 0;

		String str = sc.next();
		word = new char[n];
		a = new int[n][n];
		//for(int i = 0; i < n; i++) a[i][i] = 0;

		sc.close();

		for (int i = 0; i < n; i++)
			word[i] = str.charAt(i);

		for (int left = 1; left < n; left++) {
			for (int right = left - 1; right > 0; right--) {
				func(left, right);
			}
		}
		System.out.print(count);
	}

}