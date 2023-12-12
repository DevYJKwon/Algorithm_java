import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16935 {
	static int[][] map;
	static int N, M, R;

	/*
	 * 연산 1 상하 반전 연산 2 좌우 반전 연산 3 오른쪽으로 90 연산 4 왼쪽 90 연산 5 N/2 M/2 4군데로 잘라서 오른쪽 한 칸씩
	 * 연산 6 4군데로 잘라서 왼쪽 한 칸씩
	 * 
	 * N,M은 짝수
	 * 
	 * 첫째 줄 배열 크기 N,M 연산 횟수 R 둘째 줄 ~ 배열 원소 공백 구분 원소는 int 범위 내 마지막 줄 수행해야하는 연산 공백 구분
	 */

	static void rotate1() {
		int[][] tmp = new int[N][M];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				tmp[y][x] = map[N - 1 - y][x];
			}
		}
		map = tmp.clone();
	}

	static void rotate2() {
		int[][] tmp = new int[N][M];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				tmp[y][x] = map[y][M - 1 - x];
			}
		}
		map = tmp.clone();
	}

	static void rotate3() {
		int[][] tmp = new int[M][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				tmp[x][N - 1 - y] = map[y][x];
			}
		}
		map = tmp.clone();
		int temp = N;
		N = M;
		M = temp;
	}

	static void rotate4() {
		int[][] tmp = new int[M][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				tmp[M - 1 - x][y] = map[y][x];
			}
		}
		map = tmp.clone();
		int temp = N;
		N = M;
		M = temp;
	}

	static void rotate5() {
		int width = M / 2;
		int height = N / 2;
		int[][] tmp = new int[N][M];
		int[][] dy = { { 0, height, height, 0 }, { 0, 0, height, height } };
		int[][] dx = { { width, width, 0, 0 }, { 0, width, width, 0 } };

		for (int i = 0; i < 4; i++) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					tmp[y + dy[0][i]][x + dx[0][i]] = map[y + dy[1][i]][x + dx[1][i]];
				}
			}
		}
		map = tmp.clone();
	}

	static void rotate6() {
		int width = M / 2;
		int height = N / 2;
		int[][] tmp = new int[N][M];
		int[][] dy = { { 0, height, height, 0 }, { 0, 0, height, height } };
		int[][] dx = { { 0, 0, width, width }, { width, 0, 0, width } };

		for (int i = 0; i < 4; i++) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					tmp[y + dy[0][i]][x + dx[0][i]] = map[y + dy[1][i]][x + dx[1][i]];
				}
			}
		}
		map = tmp.clone();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // col
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int action = Integer.parseInt(st.nextToken());

			switch (action) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			}

		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				sb.append(map[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
