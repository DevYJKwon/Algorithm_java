import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj9252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int n = str1.length();
		int m = str2.length();
		int [][] lcs = new int [n+1][m+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i==0 || j==0) {
					lcs[i][j]=0;
					continue;
				}
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j]=lcs[i-1][j-1]+1;
				}
				else {
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		int i=n, j=m;
		while( i > 0 && j >0) {
			if(i==0 || j ==0) {
				break;
			}
			
			if(lcs[i-1][j] == lcs[i][j]) {
				i--;
			}
			else if(lcs[i][j-1] == lcs[i][j]) {
				j--;
			}
			else {
				sb.append(str1.charAt(i-1));
				i--;
				j--;
			}
		}
		
		sb.reverse();
		System.out.println(lcs[n][m]);
		System.out.println(sb);
	}	

}
