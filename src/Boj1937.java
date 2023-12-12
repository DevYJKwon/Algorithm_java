import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1937 {
	static int [][] map;
	static int [][] visited;
	static int max=0,n;
	
	static int dfs(int x, int y) {
		if(visited[y][x] >-1) {
			return visited[y][x];
		}
		int sum=0;
		int dx[]= {0,1,-1,0};
		int dy[]= {1,0,0,-1};
		
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx >=0 && ny >=0 && nx < n && ny < n && map[ny][nx] > map[y][x]) {
				
				if(visited[ny][nx]==-1) {
					sum=Math.max(sum,dfs(nx,ny));
				}
				else {
					sum = Math.max(visited[ny][nx], sum);
				}
				
			}
		}
		visited[y][x] = sum+1;
		return sum+1;
	}

	public static void main(String[] args) throws  IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		visited = new int [n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				max = Math.max(dfs(x,y),max); 
			}
		}
		System.out.println(max);
	}

}
