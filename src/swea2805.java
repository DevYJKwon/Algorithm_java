import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for (int r = 0; r < n; r++) {
				char[] line = br.readLine().toCharArray();
				for (int c = 0; c < n; c++) {
					map[r][c] = line[c] - '0';
				}
			}
			int sum = 0;
			int start = n / 2, end = n / 2;
			for (int r = 0; r < n / 2; r++) {
				for (int i = 0; i <= end - start; i++) {
					sum += map[r][start + i];
				}
				for (int i = 0; i <= end - start; i++) {
					sum += map[n - 1 - r][start + i];
				}
				start--;
				end++;
			}
			for (int c = 0; c < n; c++) {
				sum += map[n / 2][c];
			}
			sb.append(String.format("#%d %d\n", t, sum));

		}
		System.out.print(sb);
	}

}
