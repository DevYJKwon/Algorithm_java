import java.util.*;
import java.awt.Point;
import java.io.*;

public class Boj2468 {
	/*
	 * 높이 1~100까지 안전구역의 최대 개수
	 * 비 1~99 반복
	 * 비가 내린 칸은 visited로 가지 않음, bfs 횟수 세기
	 * 
	 */
	static int n;
	static int [][] map;
	static boolean [][] visited;
	static int [] dy = {0,0,1,-1};
	static int [] dx = {1,-1,0,0};
	
	static int check() {
		int max =0;
		for(int i=0; i<100; i++) {
			visited = new boolean [n][n];
			int cnt=0;
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					if(!visited[y][x] && map[y][x] > i) {
						bfs(x,y,i);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		return max;
	}
	
	static void bfs(int x, int y,int rain) {
		Queue<Point>q = new ArrayDeque<>();
		q.add(new Point(x,y));
		visited[y][x]=true;

		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = dy[i]+cur.y;
				int nx = dx[i]+cur.x;
				if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[ny][nx] && map[ny][nx]>rain) {
					q.add(new Point(nx,ny));
					visited[ny][nx]=true;
				}
			}
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int y=0; y<n; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0 ; x<n; x++) {
				map[y][x]= Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(check());
	}

}
