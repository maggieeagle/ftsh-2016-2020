
//Oryol Margarita
//E

import java.util.ArrayList;
import java.util.Scanner;

public class E6 {

	static ArrayList<Integer> a = new ArrayList<>();

	public static int read(int l, int r) {
		int answer = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) == l && a.get(i + 1) == r && i%3==0)
				answer = a.get(i + 2);
		}
		return answer;
	}
	
	public static void write(int l, int r, int value) {
		
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) == l + 1 && a.get(i + 1) == r - 1 && i%3==0  && l+1 <= r-1) {
			a.set(i, l);
			a.add(i+1, r);
			a.add(i+2, value);}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int number = 0;

		String str = sc.next();
		char[] string = new char[n];

		sc.close();

		for (int i = 0; i < n; i++) {
			a.add(i);
			a.add(i);
			a.add(0);
		}

		// System.out.print(a);

		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {

				if (str.charAt(j) != str.charAt(i))
					write(j, i, 1 + read(j+1, i-1));
				else
					write(j, i, read(j+1, i-1));

				if (read(j, i) <= k)
					number++;
			}
		}

		System.out.println(number + n);
		for(int i = 0, j = 0; i < a.size()/3; i++, j+=3) {
			System.out.println(a.get(j) + " " + a.get(j+1) + " " + a.get(j+2));
		}
	}

}
