import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj7579 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int [][] arr = new int [2][n];
		
		for(int j=0; j<2; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[j][i]=Integer.parseInt(st.nextToken());
			}
		}
		
		
	}

}
