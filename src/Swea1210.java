import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210 {
	static int [][] map;
	static boolean search(int startPoint) {
		boolean [][]visited = new boolean [100][100];
		int y=0,x=startPoint;
		boolean res = false;
		while(y < 100) {
			visited[y][x]=true;
			if(map[y][x]==2) {
				return true;
			}
			
			if(x-1 >= 0 && map[y][x-1] == 1 && !visited[y][x-1]) {
				visited[y][x-1]=true;
				x--;
				continue;
			}
			else if(x+1 < 100 && map[y][x+1] == 1 && !visited[y][x+1]) {
				visited[y][x+1]=true;
				x++;
				continue;
			}
			y++;
		}
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t<10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			map = new int [100][100];
			
			for(int r=0; r<100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<100; c++) {
					map[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<100; i++) {
				if(map[0][i]==1) {
					if(search(i)) {
						sb.append(String.format("#%d %d\n", testCase,i));
						break;
					}
				}
			}
			
		}
		System.out.println(sb);
	}

}
