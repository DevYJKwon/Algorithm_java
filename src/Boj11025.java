import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11025 {

	// (jp(n - 1, k) + k - 1) % n + 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp=1;
		for (int i = 1; i <= n; i++) {
			dp = (dp+(k-1))%i+1;
		}
		System.out.println(dp);
	}
}
