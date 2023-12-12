import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500 {
	
	static void getComb(Point [] list , int nth,int sum) {
		if(nth == 4) {
			res = Math.max(sum,res);
			return;
		}
		for(int i=0; i<nth; i++) {
			int x = list[i].x;
			int y = list[i].y;
			for(int d=0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx >=0 && ny >=0 && nx < m && ny <n && !visited[ny][nx]) {
					visited[ny][nx]=true;
					list[nth]=new Point(nx,ny);
					getComb(list,nth+1,sum+map[ny][nx]);
					visited[ny][nx]=false;
				}
			}
		}
	}
	
	static int [][] map;
	static boolean [][] visited;
	static int res=0;
	static int [] dy = {0,0,-1,1};
	static int [] dx = {-1,1,0,0};
	static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean [n][m];
		for(int y=0; y<n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				Point [] list = new Point [4];
				list[0]= new Point(x,y);
				visited[y][x]=true;
				getComb(list,1,map[y][x]);
				visited[y][x]=false;
			}
		}
		System.out.println(res);
	}

}
