import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//L
 
public class L {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[][] arr = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
 
        int count;
 
        for (int i = 0; i < n; i++) {
        	count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) count++;
            }
            System.out.println(count);
        }
 
    }
}