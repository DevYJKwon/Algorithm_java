import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int block = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int time =Integer.MAX_VALUE;
		int height=0;
		for (int i = 0; i < 257; i++) {
			int b =block;
			int t = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (i > map[y][x]) {
						t += i - map[y][x];
						b -= i-map[y][x];
					} 
					else if (i < map[y][x]) {
						t += 2 *(map[y][x] - i);
						b+=map[y][x]-i;
					}
				}
			}
			if(time >= t && b >= 0) {
				time = t;
				height=i;
			}
		}

		System.out.printf("%d %d",time,height);
	}

}
