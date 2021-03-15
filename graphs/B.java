import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Oryol Margarita
//B
 
public class B {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[][] arr = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
 
        int flag = 0;
 
        for (int i = 0; i < n; i++) {
            if(arr[i][i] == 1) {
            	flag = 1;
            	break;
            }
        }
 
        if (flag == 0)
            System.out.print("NO");
        else
            System.out.print("YES");
 
    }
}