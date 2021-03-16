// Oryol Margarita 2020à
// 10.10.2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Largest_subsequence {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("input.txt");
		Scanner sc = new Scanner(f);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i = 0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		int a[] = new int[n];
		int x[] = new int[n];
		for( int i = 0;i<n;i++) {
			a[i] = 1;
			x[i] = -1;
			for(int j = 0;j<i;j++) {
				if(num[j]<num[i] && a[j]+1>a[i]) {
					x[i] = j;
					a[i] = a[j]+1;		
				}
			}
		}
		int maxSeq = 1;
		int end = 0;
		for(int i = 0;i<n;i++) {
			if(a[i]>maxSeq) {
				maxSeq = a[i];
				end = i;
			}
		}
		int[] ans = new int[maxSeq];
		System.out.println(maxSeq);
	}

}
