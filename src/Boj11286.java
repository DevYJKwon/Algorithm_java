import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < 0 && o2 <0) {
					return Integer.compare(Math.abs(o1), Math.abs(o2));
				}
				else if(o1 <0 && o2 >0) {
					if(Math.abs(o1) <= Math.abs(o2)) {
						return -1;
					}
					else {
						return 1;
					}
				}
				else if(o1 >0 && o2 <0) {
					if(Math.abs(o1) >= Math.abs(o2)) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return Integer.compare(Math.abs(o1), Math.abs(o2));
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input ==0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else {
				pq.add(input);
			}
		}
		System.out.println(sb);
	}

}
