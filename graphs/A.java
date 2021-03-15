import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
//Oryol Margarita
//A
 
public class A {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] arr = new int[n];
 
        for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
        }
 
        int[] help = arr;

		Arrays.sort(help);

		for (int i = 0; i < n; i++) {
			System.out.print(help[i] + " ");
		}
		System.out.println();
 
    }
}