import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj7568 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Point [] arr = new Point [n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x,y);
		}
		
		for(int i=0; i<n; i++) {
			int rank=1;
			for(int j=0; j<n; j++) {
				if(i==j) {
					continue;
				}
				if(arr[i].x < arr[j].x && arr[i].y <arr[j].y) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}

}
