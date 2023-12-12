import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea9229 {
	static int[] arr;
	static int max = -1;
	static int n, m;

	static void permutation(int r, int[] choosed, boolean[] visited) {
		if (r == choosed.length) {
			int sum = choosed[0] + choosed[1];
			if (sum > m) {
				return;
			}
			if (sum > max) {
				max = sum;
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				choosed[r] = arr[i];
				visited[i] = true;
				permutation(r + 1, choosed,visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			permutation(0, new int[2], new boolean[n]);
			sb.append(String.format("#%d %d\n", t, max));
		}
		System.out.println(sb);
	}

}
