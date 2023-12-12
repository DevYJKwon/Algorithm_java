import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1194 {
	/*
	 * 빈 칸: 언제나 이동 가능 (.)
	 * 벽: 절대 이동 불가 (#)
	 * 열쇠: 언제나 이동. 열쇠를 집는다 (a,b,c,d,e,f)
	 * 문: 대응하는 열쇠가 있을 때만 (A,B,C,D,E,F)
	 * 현재 위치 : 0
	 * 출구: 나가야하는 곳 (1)
	 * 사방이동 1칸
	 * 미로를 탈출하는데 걸리는 이동 횟수의 최솟값
	 * 미로의 세로 N 가로 M 1이상 50이하
	 * 문에 대응하는 열쇠가 없을 수도 있음.
	 * 열쇠 여러번 사용 가능.
	 * 탈출 할 수 없으면 -1
	 * 
	 * bfs 탐색
	 * visited 체크 만약 열쇠를 먹으면 visited 열쇠로 체크
	 */
	static class Node{
		int x,y,d,k;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k =k;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", k=" + Integer.toBinaryString(k) + "]";
		}
		
	}
	
	static int bfs(Node start) {
		int res=-1;
		visited = new boolean [n][m][1<<6];
		Queue<Node> q = new ArrayDeque<>();
		visited[start.y][start.x][0]=true;
		q.add(start);
		int [] dy = {1,0,0,-1};
		int [] dx = {0,1,-1,0};
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = cur.y+dy[i];
				int nx = cur.x+dx[i];
				int key = cur.k;
				if(nx>=0 && ny>=0 && nx < m && ny < n && !visited[ny][nx][key] && map[ny][nx]!='#') {
					int next= map[ny][nx];
					if(map[ny][nx]=='1') {
						res = cur.d+1;
						return res;
					}
					else if(next >= 'a' && next <= 'f') {
						key = key | (1<< (next-'a'));
					}
					else if(next >= 'A' && next <='F'){
						int r = key & (1<<(next-'A'));
						if(r == 0) {
							continue;
						}
					}
					q.add(new Node(nx,ny,cur.d+1,key));
					visited[ny][nx][key]=true;
				}
			}
		}
		
		return res;
	}
	static char [][] map;
	static boolean  [][][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char [n][m];
		Node start = null;
		for(int y=0; y<n;y++) {
			String str = br.readLine();
			for(int x=0; x<m; x++) {
				map[y][x]= str.charAt(x);
				if(map[y][x]=='0') {
					start = new Node(x,y,0,0);
				}
			}
		}
		int res = bfs(start);
		System.out.println(res);
	}

}
