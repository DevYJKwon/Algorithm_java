import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		int cnt = 0;
		int i = 0, idx = 0;
		while (cnt < n) {
			
			if(arr[i]) {
				if(idx == k) {
					cnt++;
					arr[i] = false;
					if(i==0) {
						sb.append(n).append(", ");
					}
					else {
						sb.append(i).append(", ");
					}
					idx=0;
				}
				idx++;
			}
			i=++i%n;
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">\n");
		System.out.println(sb);
	}

}
