import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17070 {
	static final int R = 0,C=1,D=2;
	
	static int [][] map;
	static int n;
	static int cnt=0;
	static int [][] dy = {{0,1},{0,1,1}, {1,1}};
	static int [][] dx = {{1,1},{1,1,0}, {1,0}};
	static void dfs(int x, int y, int pipe) {
		if(x==n-1 && y==n-1) {
			cnt++;
			return;
		}
		
		if(pipe == R) {
			if(isIn(x+1,y,R)) {
				dfs(x+1,y,R);
			}
			if(isIn(x+1,y+1,C)) {
				dfs(x+1,y+1,C);
			}
		}
		else if(pipe ==C) {
			if(isIn(x+1,y,R)) {
				dfs(x+1,y,R);
			}
			if(isIn(x+1,y+1,C)) {
				dfs(x+1,y+1,C);
			}
			if(isIn(x,y+1,D)) {
				dfs(x,y+1,D);
			}
		}
		else {
			if(isIn(x,y+1,D)) {
				dfs(x,y+1,D);
			}
			if(isIn(x+1,y+1,C)) {
				dfs(x+1,y+1,C);
			}
		}
	}
	static boolean isIn(int nx,int ny, int pipe) {
		if(nx>=0 && ny>=0 && nx<n && ny<n && map[ny][nx]==0) {
			if(pipe==C) {
				if(map[ny][nx-1]==0 && map[ny-1][nx]==0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		StringTokenizer st;
		for(int y=0; y<n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<n; x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,0,R);
		System.out.println(cnt);
	}

}
