import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3109 {
	
	/*
	 *  R*C
	 *  →, ↘ , ↗
	 *  
	 */
	static char [][] map;
	static int max=0,r,c;
	static boolean [][]visited;
	static boolean dfs(int x, int y) {
		if(x==c-1 && map[y][x]=='.') {
			max++;
			return true;
		}
		int [] dy = {-1,0,1};
		int [] dx = {1,1,1};
		
		for(int i=0; i<3; i++) {
			int ny = dy[i]+y;
			int nx =  dx[i]+x;
			if(ny >=0 && ny < r && map[ny][nx]=='.' && !visited[ny][nx]) {
				visited[ny][nx]=true;
				if(dfs(nx,ny)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean [r][c];
		for(int y=0; y<r; y++) {
			String str = br.readLine(); 
			for(int x=0; x<c; x++) {
				map[y][x]=str.charAt(x);
			}
		}
		
		for(int i=0; i<r; i++) {
			dfs(0,i);
		}
		System.out.println(max);
	}

}
