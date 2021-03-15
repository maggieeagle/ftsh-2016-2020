import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//M
 
public class M {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int[][] arr = new int[n][n];
 
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt() - 1;
            int p = sc.nextInt() - 1;
            arr[q][p] = 1;
            arr[p][q] = 1;
        }
 
        //int count = 0;
 
        int count;
        
        for (int i = 0; i < n; i++) {
        	count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) count++;
            }
            System.out.println(count);
        }
 
           // System.out.print(count);
 
    }
}