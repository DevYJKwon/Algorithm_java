import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(pq.isEmpty()) {
				if(num ==0) {
					sb.append(0).append("\n");
					continue;
				}
			}
			
			if(num==0) {
				sb.append(pq.poll()).append("\n");
			}
			else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}

}
