import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//E
 
public class E {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[][] arr = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
 
        int count = 0;
 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(arr[i][j] == 1) System.out.println((i+1) + " " + (j+1));
            }
        }
 
           // System.out.print(count);
 
    }
}