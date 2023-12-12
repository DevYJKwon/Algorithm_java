import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206 {
	/*
	 * NxM 행렬 이동
	 * 0은 이동 가능 1은 벽
	 * 1,1 -> N,M으로 가야함
	 * 벽은 한 번 부술 수 있다.
	 * 상하좌우 사방탐색
	 * 최단 이동 횟수를 구하시오
	 * 갈 수 없으면 -1
	 */
	static class Node{
		int x,y,d,j;

		public Node(int x, int y, int d,int j) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.j=j;
		}
		
	}
	static int r,c;
	static int [][] map;
	static int [] dy= {0,1,-1,0};
	static int [] dx = {1,0,0,-1};
	static int bfs() {
		boolean[][][] visited = new boolean[2][r][c];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,0,0,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x==c-1 && cur.y==r-1) {
				return cur.d+1;
			}
			for(int i=0; i<4; i++) {
				int ny=cur.y+dy[i];
				int nx =cur.x+dx[i];
				if(nx>=0 && ny >=0 && nx <c && ny <r &&!visited[cur.j][ny][nx]) {
					if(map[ny][nx]==0) {
						visited[cur.j][ny][nx]=true;
						q.add(new Node(nx,ny,cur.d+1,cur.j));
					}
					else {
						if(cur.j==0) {
							visited[cur.j+1][ny][nx]=true;
							q.add(new Node(nx,ny,cur.d+1,cur.j+1));
						}
					}
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
			String line = br.readLine();
			for(int x=0; x<c; x++) {
				map[y][x] = line.charAt(x)-'0';
			}
		}
		System.out.println(bfs());
	}

}
