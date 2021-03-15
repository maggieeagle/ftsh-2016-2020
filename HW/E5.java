//Oryol Margarita
//E

import java.util.Scanner;

public class E5 {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int answer = 0;
	 
	        String str = sc.next();
	 
	        sc.close();
	 
	        int[][] a = new int[n][n];
	        
	        for(int i = 0; i < n-1; i++) {
	        	a[i][i] = 0;
	        	if(str.charAt(i) != str.charAt(i+1)) a[i][i+1] = 1;
	        }
	        a[n-1][n-1] = 0;
	        
	        for(int length = 3; length <= n; length++) {
	        	for(int left = 0; left + length - 1 < n; left++) {
	        		int right = left + length - 1;
	        		if(str.charAt(left) != str.charAt(right)) 
	        			a[left][right] = 1;
	        		a[left][right] += a[left + 1][right - 1];
	        		//if(a[left][right] <= k) answer++;
	        	}
	        }
	        
	        for(int i = 0; i < n; i++) {
	        	for(int j = i; j < n; j++) {
	        		if(a[i][j] <= k) answer++;
	        	}
	        }

	        System.out.println(answer);
	}

}
