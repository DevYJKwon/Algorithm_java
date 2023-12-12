import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ingre {
	int s;
	int b;

	Ingre(int s, int b) {
		this.s = s;
		this.b = b;
	}
}

public class Boj2961 {
	static Ingre[] arr;
	static int min = Integer.MAX_VALUE;
	static int n;

	static void comb(int r, boolean[] choosed) {
		if (r == choosed.length) {
			int sum = 0;
			int mul = 1;
			int cnt=0;
			for (int i = 0; i < choosed.length; i++) {
				if (choosed[i]) {
					sum += arr[i].b;
					mul *= arr[i].s;
					continue;
				}
				cnt++;
			}
			if(cnt == choosed.length) {
				return;
			}
			min = Math.min(Math.abs(sum - mul), min);
			return;
		}
		
		choosed[r]= false;
		System.out.println(r+" "+Arrays.toString(choosed));
		comb(r + 1, choosed);
		choosed[r] = true;
		System.out.println(r+" "+Arrays.toString(choosed));
		comb(r + 1, choosed);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new Ingre[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 신맛 -> 곱
			int s = Integer.parseInt(st.nextToken());
			// 쓴맛 -> 합
			int b = Integer.parseInt(st.nextToken());
			Ingre in = new Ingre(s, b);
			arr[i] = in;
		}
		comb(0, new boolean[n]);
		System.out.println(min);
	}

}
