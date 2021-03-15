import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//C
 
public class C {
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
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) count++;
            }
        }
 
            System.out.print(count/2);
 
    }
}