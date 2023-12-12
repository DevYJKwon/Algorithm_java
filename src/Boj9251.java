import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9251 {
	/*
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] lcs = new int[1001][1001];
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++){
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
		System.out.println(lcs[str1.length()][str2.length()]);
		
	}

}
