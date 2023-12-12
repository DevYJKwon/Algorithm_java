import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj17244 {

	
	static char [][] map;
	static int n,m,cnt;
	static Point goal;
	
	static class Node{
		int x,y,d,t;

		public Node(int x, int y, int d, int t) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", t=" + Integer.toBinaryString(t) + "]";
		}
		
	}
	
	static int bfs(Point start) {
		boolean [][][] visited = new boolean [n][m][(1<<cnt)+1];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(start.x,start.y,0,0));
		
		int [] dy = {1,0,0,-1};
		int [] dx = {0,1,-1,0};
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx >=0 && ny >=0 && nx <m && ny <n && !visited[ny][nx][cur.t] && map[ny][nx]!='#') {
					int nt = cur.t;
					if(map[ny][nx]=='G') {
						if(cur.t == Math.pow(2, cnt)-1) {
							return cur.d+1;
						}
					}
					else if(map[ny][nx] >= 'A' && map[ny][nx]<='E') {
						nt = cur.t | 1<<(map[ny][nx]-'A');
					}
					q.add(new Node(nx,ny,cur.d+1,nt));
					visited[ny][nx][nt]=true;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		cnt=0;
		map = new char [n][m];
		Point start = null;
		for(int y=0; y<n; y++) {
			String str = br.readLine();
			for(int x=0; x<m; x++) {
				map[y][x] = str.charAt(x);
				if(map[y][x]=='X') {
					map[y][x]= (char)('A'+cnt++);
				}
				else if(map[y][x]=='S') {
					start = new Point(x,y);
				}
				else if(map[y][x]=='E') {
					map[y][x]='G';
					goal = new Point(x,y);
				}
			}
		}
		int res =bfs(start);
		System.out.println(res);
	}

}
