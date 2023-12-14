import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14889 {
	static int[][] map;
	static int n;
	static int min = Integer.MAX_VALUE;

	static void comb(int nth, int index, int[] chosen) {
		if (nth == chosen.length) {
			ArrayList<Integer> other = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				other.add(i);
			}

			for (int c : chosen) {
				other.remove(Integer.valueOf(c));
			}

			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0; i<chosen.length; i++) {
				for(int j=i+1; j<chosen.length; j++) {
					int from = chosen[i];
					int to = chosen[j];
					sum1+=map[from][to];
					sum1+=map[to][from];
				}
			}
			
			for(int i=0; i<chosen.length; i++) {
				for(int j=i+1; j<chosen.length; j++) {
					int from = other.get(i);
					int to = other.get(j);
					sum2+=map[from][to];
					sum2+=map[to][from];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			
			return;
		}
		for (int i = index; i < n; i++) {
			chosen[nth] = i;
			comb(nth + 1, i + 1, chosen);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0, new int[n / 2]);
		System.out.println(min);
	}

}
