import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		int cnt=0;
		int i=n-1;
		while(k!=0) {
			int q = k/coin[i];
			int d = k%coin[i];
			cnt+=q;
			k=d;
			i--;
		}
		System.out.println(cnt);
	}

}
