import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] lines = new int[k];

		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lines);
		long left = 1, right = lines[k - 1];
		long max = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < lines.length; i++) {
				sum += lines[i] / mid;
			}
			if (sum >= n) {
				max = Math.max(max, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(max);
	}

}
