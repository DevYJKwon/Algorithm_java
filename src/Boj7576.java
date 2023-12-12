import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
	static int row,col;
	static int [][] map;
	
	static void bfs(List<Point> start) {
		boolean [][] visited = new boolean [row][col];
		Queue<Point> q = new ArrayDeque<>();
		for(Point p: start) {
			q.add(p);
			visited[p.y][p.x]=true;
		}
		
		int [] dy = {0,0,-1,1};
		int [] dx = {-1,1,0,0};
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = dy[i]+cur.y;
				int nx = dx[i]+cur.x;
				
				if(nx>=0 && ny >=0 && nx < col && ny <row && !visited[ny][nx] &&map[ny][nx]!=-1) {
					map[ny][nx]=map[cur.y][cur.x]+1;
					visited[ny][nx]=true;
					q.add(new Point(nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		List<Point> start = new ArrayList<>();
		map = new int [row][col];
		for(int y=0; y<row; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<col; x++) {
				map[y][x]= Integer.parseInt(st.nextToken());
				if(map[y][x]==1) {
					start.add(new Point(x,y));
				}
			}
		}
		
		bfs(start);
		int max =0;
		for(int y=0; y<row; y++) {
			for(int x=0; x<col; x++) {
				if(map[y][x]==0) {
					max =-1;
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[y][x]-1);
			}
		}
		System.out.println(max);
	}

}
