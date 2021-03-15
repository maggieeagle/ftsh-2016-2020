//Oryol Margarita
//E
 
import java.util.Scanner;
 
public class E4 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
        int number = 0;
 
        String str = sc.next();
        //char[] string = new char[n];
 
        sc.close();
 
        /*for (int i = 0; i < n; i++)
            string[i] = str.charAt(i);*/
 
        int[][] a = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            a[i][i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
 
                int count = 0;
 
                /*
                 * System.out.println(i + " " + j);
                 *
                 * for(int p = j; p < i+1; p++) { System.out.print(string[p] + " "); }
                 * System.out.println();
                 */
 
                /*
                 * for(int r = (j - i)/2; r >= 0; r--) { if(string[i + r]!=string[j-r]) count++;
                 * }
                 */
                // count/=2;
 
                //if (j + 1 <= i - 1) {
                if(i==j) a[j][i] = 0;
                if(i - j == 1) {
                    if(str.charAt(j)==str.charAt(i)) a[j][i] = 0;
                    else a[j][i] = 1;
                }
                if(i - j > 1) {
                    if (str.charAt(j) != str.charAt(i))
                        a[j][i] = 1 + a[j + 1][i - 1];
                    else
                        a[j][i] = a[j + 1][i - 1];
                }
                /*}
                else {
                    if (string[j] != string[i])
                        a[j][i] = 1 + a[i-1][j+1];
                    else
                        a[j][i] = a[i-1][j+1];
                }*/
 
                if (a[j][i] <= k)
                    number++;
            }
        }
 
        System.out.print(number + n);
    }
 
}