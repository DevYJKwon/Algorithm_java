import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
	static class Tomato{
		int x,y,z,d;

		public Tomato(int x, int y, int z,int d) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}
		
	}
	static int r,c,h;
	static int [][][] map;
	static int day=0;
	static boolean [][][] visited;
	
	static void bfs(List<Tomato> list) {
		visited = new boolean [h][r][c];
		Queue <Tomato> q = new ArrayDeque<>();
		
		int [] dy = {0,1,0,-1,0,0};
		int [] dx = {1,0,-1,0,0,0};
		int [] dz = {0,0,0,0,1,-1};
		
		for(Tomato t : list) {
			q.add(t);
			visited[t.z][t.y][t.x]=true;
		}
		
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			day = Math.max(day, cur.d);
			for(int i=0; i<6; i++) {
				int ny = cur.y+dy[i];
				int nx = cur.x+dx[i];
				int nz = cur.z+dz[i];
				if(ny >=0 && nx >=0 && nz>= 0 && nx < c && ny < r && nz <h && !visited[nz][ny][nx] && map[nz][ny][nx]!=-1) {
					q.add(new Tomato(nx,ny,nz,cur.d+1));
					visited[nz][ny][nx]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int [h][r][c];
		List<Tomato> list = new ArrayList<>();
		for(int z=0; z<h; z++) {
			for(int y = 0; y<r; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<c; x++) {
					map[z][y][x] = Integer.parseInt(st.nextToken());
					if(map[z][y][x] ==1) {
						list.add(new Tomato(x,y,z,0));
					}
				}
			}
		}
		bfs(list);
		outer:for(int z=0; z<h; z++) {
			for(int y = 0; y<r; y++) {
				for(int x=0; x<c; x++) {
					if(!visited[z][y][x] && map[z][y][x]!=-1) {
						day=-1;
						break outer;
					}
				}
			}
		}
		System.out.println(day);
	}

}
