import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17143 {
	/*
	 * RxC 격자판 칸에는 상어가 최대 1마리 상어는 크기와 속도를 가지고 있다. 낚시왕의 초기 위치는 0,0 -> R-1,C-1를 가면 멈춘다
	 * 매 초마다 오른쪽으로 한 칸 이동, 해당 열 중에 y가 가장 작은 상어를 잡는다. 상어는 매 초마다 이동한다. 해당 방향으로 속도 만큼
	 * 움직임. 만약 범위를 넘어가면 방향을 반대로 바꿔서 간다. 만약 상어가 만난다면 큰 상어가 작은 상어를 먹는다.
	 * 
	 * R,C,M(상어 수)가 한 줄로 주어진다. 각 상어가 M줄에 거쳐서 입력으로 주어진다.
	 * r,c,s(speed),d(direction),z(size) 같은 크기를 가진 상어는 존재하지 않는다. d: 1 위 2 아래 3우 4왼
	 * 낚시왕이 잡은 상어의 크기의 합을 출력
	 */
	static class Fisher {
		Point pos;
		int sum;

		public Fisher(Point pos, int sum) {
			this.pos = pos;
			this.sum = sum;
		}

		public void fishing() {
			for (int y = 0; y < r; y++) {
				if (map[y][pos.x] != null) {
					sum += map[y][pos.x].size;
					map[y][pos.x] = null;
					break;
				}
			}
		}

	}

	static class Shark {
		int speed, direction, size;

		public Shark(int speed, int direction, int size) {
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int r, c, m;
	static Shark[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Fisher f = new Fisher(new Point(0, 0), 0);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			if (d == 1) { // direction 순환을 위해 아래와 우의 순서를 바꿔준다.
				d = 2;
			} else if (d == 2) {
				d = 1;
			}
			int z = Integer.parseInt(st.nextToken());
			if (d == 0 || d == 2) { // 상 하에서 반복횟수를 줄이기 위해 %연산
				s = s % ((r - 1) * 2);
			} else { // 좌 우 연산횟수 줄이기
				s = s % ((c - 1) * 2);
			}
			map[y][x] = new Shark(s, d, z);
		}
		for (; f.pos.x < c; f.pos.x++) {
			f.fishing();
			moveShark();
		}
		System.out.println(f.sum);
	}

	static void moveShark() {
		Shark[][] temp = new Shark[r][c];
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				if (map[y][x] != null) {
					Shark cur = map[y][x];
					int curR = y + dy[cur.direction] * cur.speed;
					int curC = x + dx[cur.direction] * cur.speed;
					while (curR < 0 || curR > r - 1) { // 상 하 범위를 넘었는가?
						if (curR < 0) { // 이동 횟수가 음수라면
							curR = Math.abs(curR); // 0에서부터 내 위치를 뺀 이동횟수 => 0+(d*speed+y)
							cur.direction = (cur.direction + 2) % 4; //방향 전환
						}
						if (curR > r - 1) { //이동 횟수가 범위를 넘어간다면
							curR = (r - 1) * 2 - curR; // 끝에서부터 이동횟수 만큼 이동 => (r-1)-(d*speed-((r-1)-y))
							cur.direction = (cur.direction + 2) % 4;
						}
					}
					while (curC < 0 || curC > c - 1) {
						if (curC < 0) {
							curC = Math.abs(curC);
							cur.direction = (cur.direction + 2) % 4;
						}
						if (curC > c - 1) {
							curC = (c - 1) * 2 - curC;
							cur.direction = (cur.direction + 2) % 4;
						}
					}

					if (temp[curR][curC] != null) {
						if (cur.size < temp[curR][curC].size) {
							continue;
						}
					}
					temp[curR][curC] = cur;
				}
			}
		}
		map = temp;
	}

	static void printMap(Shark[][] map) {
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				System.out.print((map[y][x] != null ? 1 : 0) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}