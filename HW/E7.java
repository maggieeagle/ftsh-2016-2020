
//Oryol Margarita
//E

import java.util.Scanner;

public class E7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;

		String str = sc.next();

		sc.close();

		int[] a1 = new int[n];
		int[] a2 = new int[n - 1];

		for (int i = 0; i < n - 1; i++)
			if (str.charAt(i) != str.charAt(i + 1))
				a2[i] = 1;
		
		for(int i = 0; i < n-1; i++)
			if(a2[i] <= k) answer++;

		for (int length = 3; length <= n; length++) {
			for (int left = 0; left + length - 1 < n; left++) {
				int right = left + length - 1;
				if (str.charAt(left) != str.charAt(right)) {
					if ((left + right) % 2 == 0) {
						a1[(left + right) / 2] = a1[(left + right) / 2] + 1;
						if (a1[(left + right) / 2] <= k) {
							answer++;
							//System.out.println(left + " " + right);
						}
					} else {
						a2[(left + right - 1) / 2] = a2[(left + right - 1) / 2] + 1;
						if (a2[(left + right - 1) / 2] <= k) {
							answer++;
							//System.out.println(left + " " + right + " " + a2[(left + right - 1) / 2] + " " + (left + right - 1) / 2);
						}
					}
				}
				else {
					if ((left + right) % 2 == 0) {
						if (a1[(left + right) / 2] <= k) {
							answer++;
							//System.out.println(left + " " + right);
						}
					} else {
						if (a2[(left + right - 1) / 2] <= k) {
							answer++;
							//System.out.println(left + " " + right + " " + a2[(left + right - 1) / 2] + " " + (left + right - 1) / 2);
						}
					}
				}
			}
		}

		/*for (int i = 0; i < n; i++)
			System.out.print(a1[i] + " ");
		System.out.println();
		for (int i = 0; i < n - 1; i++)
			System.out.print(a2[i] + " ");
		System.out.println();*/
		
		System.out.println(answer + n);
	}

}
