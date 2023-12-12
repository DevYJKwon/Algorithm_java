import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj1931 {

	static class Course implements Comparable<Course>{
		int start,end;

		public Course(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Course o) {
			if(Integer.compare(this.end, o.end)==0) {
				return Integer.compare(this.start, o.start);
			}
			else {
				return Integer.compare(this.end, o.end);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Course> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Course(start,end));
		}
		int res=0;
		while(!pq.isEmpty()) {
			Course cur = pq.poll();
			res++;
			while(!pq.isEmpty() && pq.peek().start < cur.end) {
				pq.poll();
			}
		}
		
		System.out.println(res);
	}

}
