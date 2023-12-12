import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
	/*
	 * r*c 직사각형 연구소
	 * 각 칸은 0 빈칸 or  1벽
	 * 일부 칸은 2 바이러스가 존재하며 상하좌우로 퍼짐
	 * 새로 벽을 3개 세움
	 * 벽을 새로 세우고 바이러스가 퍼졌을 때 안전구역의 최댓값을 구하라
	 * 
	 * 
	 * 조합으로 벽의 위치를 정하고 BFS로 바이러스 전파 후 안전구역 개수 세서 최댓값 구하기
	 */
	static int r,c,max=0;
	static int [][] map;
	static int [] arr;
	static final int WALL =1, VIRUS=2;
	static List<Point> vList = new ArrayList<>();
	static void spreadVirus(Point [] walls) {
		boolean [][] visited = new boolean [r][c];
		Queue<Point> q = new ArrayDeque<>();
		
		int [][] temp = new int [r][c];
		for(int y=0; y<r; y++) {
			for(int x=0; x<c; x++) {
				temp[y][x]= map[y][x];
			}
		}
		for(int i=0; i<walls.length; i++) {
			temp[walls[i].y][walls[i].x]=WALL;
		}
		for(Point p : vList) {
			q.add(p);
			visited[p.y][p.x]=true;
		}
		int [] dy = {0,-1,1,0};
		int [] dx = {1,0,0,-1};
		int cnt=0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			temp[cur.y][cur.x]=VIRUS;
			
			for(int i=0; i<4; i++) {
				int ny = cur.y+dy[i];
				int nx = cur.x+dx[i];
				if(ny>=0 && nx >=0 && nx <c && ny < r && !visited[ny][nx] && temp[ny][nx]==0) {
					q.add(new Point(nx,ny));
					visited[ny][nx]=true;
				}
			}
		}
		
		for(int y=0; y<r; y++) {
			for(int x=0; x<c; x++) {
				if(temp[y][x]==0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
	static void makeComb(int nth, int start, int [] chosen) {
		if(nth == chosen.length) {
			//bfs
			Point[] walls = new Point[3];
			for(int i=0; i<3; i++) {
				walls[i] = new Point(chosen[i]%c, chosen[i]/c);
				if(map[walls[i].y][walls[i].x]!=0) {
					return;
				}
			}
			spreadVirus(walls);
			return;
		}
		for(int i=start; i<arr.length; i++) {
			chosen[nth]=arr[i];
			makeComb(nth+1,i+1,chosen);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		arr = new int [r*c];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		for(int y=0; y<r; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<c; x++) {
				map [y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x]==VIRUS) {
					vList.add(new Point(x,y));
				}
			}
		}
		
		makeComb(0,0, new int [3]);
		System.out.println(max);
	}

}
