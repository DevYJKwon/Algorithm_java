import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1954 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];
			// 이동 방향이 우 아래 좌 위 순이다.
			int[] dy = { 0, 1, 0, -1 };
			int[] dx = { 1, 0, -1, 0 };

			int d = 0;
			map[0][0] = 1;
			int cnt = 2;
			int y=0,x=0;
			while (cnt <= n * n) { //NxN 배열이기 때문에 N*N이 마지막 수다.
				int ny = dy[d] + y;
				int nx = dx[d] + x;
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 0) { // 맵 안에 있는지 확인
					map[ny][nx] = cnt++;
					y=ny;
					x=nx;
				} 
				else {
					d = ++d % 4;
				}
			}
			sb.append("#" + t + "\n");
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sb.append(map[r][c] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
