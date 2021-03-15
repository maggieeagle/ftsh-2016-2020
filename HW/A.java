import java.util.Scanner;

//Oryol Margarita
//A

public class A {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int string_length = str.length();
		
		char[] string = new char[string_length];
		char[] reverse_string = new char[string_length];
				
		for(int i = 0; i < string_length; i++) 
			string[i] = str.charAt(i);
		
		for(int i = 0; i < string_length; i++)
			reverse_string[i] = string[string_length - i - 1];
		
		 int[][] a = new int[string_length+1][string_length+1];
		 
		 for (int i = 1; i < string_length+1; i++) {
	            for (int j = 1; j < string_length+1; j++) {
	                if (string[i-1] == reverse_string[j-1])
	                    a[i][j] = a[i - 1][j - 1] + 1;
	                else
	                    a[i][j] = Math.max(a[i][j - 1], a[i - 1][j]);
	            }
	        }
	 
	        int count = 0;
	        for (int i = 1; i < string_length; i++) {
	            if (string[i] == string[i - 1])
	                count++;
	        }
	        for (int i = 1; i < string_length; i++) {
	            if (reverse_string[i] == reverse_string[i - 1])
	                count++;
	        }
	        if (count == string_length + string_length - 2 && string[0] == reverse_string[0])
	            a[string_length - 1][string_length - 1] = Math.min(string_length, string_length);
	 
	        int length = a[string_length][string_length];
	        
	        System.out.println(length);

	        int subseq[] = new int[length];
	        
	        int i = string_length;
	        int j = string_length;
	        int k = 0;
	        
	        while(a[i][j]!=0) {
	            if(string[i-1]==reverse_string[j-1]) {
	                subseq[k]=string[i-1];
	                i--;
	                j--;
	                k++;
	            }
	            else {
	                if(a[i-1][j] > a[i][j-1]) i--;
	                else j--;
	            }
	        }
	        
	        for(int g = length-1; g > -1; g--){
	            System.out.print(subseq[g] + " ");
	        }

	}

}
