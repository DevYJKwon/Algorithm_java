import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
	static int r,c;
	static int [][] map;
	static int bfs(int x, int y) {
		int [][] visited = new int [r][c];
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x,y));
		visited[y][x]=1;
		int [] dy = {1,0,-1,0};
		int [] dx = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.x == c-1 && cur.y == r-1) {
				return visited[cur.y][cur.x];
			}
			for(int i=0; i<4; i++) {
				int ny = cur.y+dy[i];
				int nx = cur.x+dx[i];
				if(ny >=0 && nx >=0 && ny<r && nx<c && map[ny][nx]!=0 && visited[ny][nx]==0) {
					visited[ny][nx]= visited[cur.y][cur.x]+1;
					q.add(new Point(nx,ny));
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int [r][c];
		for(int y=0; y<r; y++) {
			String str = br.readLine();
			for(int x=0; x<c; x++) {
				map[y][x]=str.charAt(x)-'0';
			}
		}
		
		System.out.println(bfs(0,0));
	}

}
