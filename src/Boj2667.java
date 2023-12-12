import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Boj2667 {
	static int [][] map;
	static int n, visited=2;
	static List<Integer> list = new ArrayList<>();
	
	static void bfs(int x, int y) {
		int cnt=0;
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x,y));
		map[y][x]=visited;
		int [] dy = {0,1,-1,0};
		int [] dx= {-1,0,0,1};
		while(!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;
			for(int i=0; i<4; i++) {
				int ny = dy[i]+cur.y;
				int nx = dx[i]+cur.x;
				
				if(nx>=0 && ny >=0 && nx < n && ny <n && map[ny][nx] ==1) {
					map[ny][nx] = visited;
					q.add(new Point(nx,ny));
				}
			}
		}
		list.add(cnt);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		for(int y=0; y<n; y++) {
			String str = br.readLine();
			for(int x=0; x<n; x++) {
				map[y][x] = str.charAt(x)-'0';
			}
		}
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				if(map[y][x]==1) {
					bfs(x,y);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i:list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
