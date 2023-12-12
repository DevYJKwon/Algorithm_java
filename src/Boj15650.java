import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	
	static void comb(int start, int r,int [] choosed) {
		if(r == choosed.length) {
			for(int i : choosed) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			choosed[r]= i;
			comb(i+1,r+1,choosed);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int [] choosed = new int [r];
		
		comb(1,0,choosed);
		System.out.println(sb);
	}
	


}
