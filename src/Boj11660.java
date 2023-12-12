import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][]map = new int [n+1][n+1];
		
		for(int r=1; r<=n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=n; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c]=num+map[r-1][c]+map[r][c-1]-map[r-1][c-1];
			}
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int fromY = Integer.parseInt(st.nextToken());
			int fromX = Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());
			int toX = Integer.parseInt(st.nextToken());
			
			sb.append(map[toY][toX]-map[toY][fromX-1]-map[fromY-1][toX]+map[fromY-1][fromX-1]);
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
