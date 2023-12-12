import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15652 {
	static StringBuilder sb = new StringBuilder();
	static int n,c;
	static void makeComb(int nth,int start, int [] chosen) {
		if(nth == chosen.length) {
			for(int i:chosen) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			chosen[nth]=i;
			makeComb(nth+1,i,chosen);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken()); 
		
		makeComb(0,1,new int [c]);
		System.out.println(sb);
	}	

}
