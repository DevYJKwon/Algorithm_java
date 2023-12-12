import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11401 {
	public static final int p = 1000000007;

	static long divPow(long num, long n) {

		if (n == 0) {
			return 1;
		}

		long res = divPow(num, n / 2);

		if (n % 2 == 0) {
			return (res * res) % p;
		} else {
			return ((res * res) % p * num) % p;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		long[] fac = new long[n+1];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i <= n; i++) {
			fac[i] = (fac[i - 1] * i) % p;
		}
		System.out.println(((fac[n] * divPow((fac[n - r] * fac[r]) % p, p - 2) % p) % p));
	}

}