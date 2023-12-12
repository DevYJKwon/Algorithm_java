import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		int [][] fibo = new int[41][2];
		
		fibo[0][0]=1;
		fibo[0][1]=0;
		fibo[1][0]=0;
		fibo[1][1]=1;
		
		for(int i=2; i<=40; i++) {
			fibo[i][0] = fibo[i-1][0]+fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1]+fibo[i-2][1];
		}
		
		for(int t =0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fibo[n][0]+" "+fibo[n][1]).append("\n");
		}
		System.out.println(sb);
	}

}
