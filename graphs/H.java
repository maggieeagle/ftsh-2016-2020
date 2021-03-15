import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//H
 
public class H {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int[][] arr = new int[n][n];
 
        for (int i = 0; i < m; i++) {
        	int q = sc.nextInt() - 1;
        	int p = sc.nextInt() - 1;
        	arr[q][p] = 1;
        }
 
        //int count = 0;
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
 
           // System.out.print(count);
 
    }
}