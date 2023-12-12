import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {
	static int[][] map;
	static int n,m;
	static void bfs(Point start) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		
		int [] dx = {1,0,0,-1};
		int [] dy = {0,1,-1,0};
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = dy[i]+cur.y;
				int nx = dx[i]+cur.x;
				
				if(ny>=0 && nx>=0 && ny <n && nx <m && map[ny][nx]==-1) {
					map[ny][nx]=map[cur.y][cur.x]+1;
					q.add(new Point(nx,ny));
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		Point start = null;
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2) {
					map[y][x]=0;
					start = new Point(x, y);
				}
				else if(map[y][x]==1) {
					map[y][x]=-1;
				}
			}
		}
		bfs(start);
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}

	}

}
