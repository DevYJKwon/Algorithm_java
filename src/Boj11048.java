import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11048 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] map = new int[n][m];
		int [] dy = {-1,-1,0};
		int [] dx = {-1,0,-1};
		for(int y=0; y<n; y++) {
			st= new StringTokenizer(br.readLine());
			for(int x=0; x<m; x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				int max=0;
				for(int i=0; i<3; i++) {
					int ny=dy[i]+y;
					int nx=dx[i]+x;
					if(ny>=0 && nx >=0 && ny <n && nx <m) {
						max= Math.max(map[ny][nx], max);
					}
				}
				map[y][x]+=max;
			}
		}
		int max =0;
		for(int x=0; x<m; x++) {
			max= Math.max(max, map[n-1][x]);
		}
		System.out.println(max);
	}

}
