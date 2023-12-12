import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj10026 {
	static int n;
	
	static int bfs(char [][] graph) {
		int [][] visited = new int [n][n];
		int cnt=1;
		
		int [] dy = {0,1,-1,0};
		int [] dx = {1,0,0,-1};
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				if(visited[y][x]!=0) {
					continue;
				}
				Queue<Point>q = new ArrayDeque<>();
				q.add(new Point(x,y));
				visited[y][x]=cnt;
				while(!q.isEmpty()) {
					Point cur = q.poll();
					
					for(int i=0; i<4; i++) {
						int ny = dy[i]+cur.y;
						int nx = dx[i]+cur.x;
						
						if(nx >=0 && ny >=0 && nx < n && ny < n && visited[ny][nx]==0) {
							if(graph[ny][nx]== graph[cur.y][cur.x]) {
								visited[ny][nx]=cnt;
								q.add(new Point(nx,ny));
							}
						}
					}
					
				}
				cnt++;
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char [][] rgb = new char[n][n];
		char [][] rb = new char[n][n];
		for(int y=0; y<n; y++) {
			String str = br.readLine();
			for(int x=0; x<n; x++){
				rgb[y][x] = str.charAt(x);
				rb[y][x]=str.charAt(x);
				if(rb[y][x]=='G') {
					rb[y][x]='R';
				}
			}
		}
		System.out.println((bfs(rgb)-1)+" "+(bfs(rb)-1));
		
	}

}
