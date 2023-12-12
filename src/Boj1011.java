import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			int distance = goal-start;
			int max = (int) Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				sb.append(max*2-1).append("\n");
			}
			else if(distance <= max*max+max) {
				sb.append(max*2).append("\n");
			}
			else {
				sb.append(max*2+1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
