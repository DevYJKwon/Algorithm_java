import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11000 {
    static class Course implements Comparable<Course>{
        int start, end;

        public Course(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
        	int result = Integer.compare(this.end, o.end);
        	if(result ==0) {
        		return Integer.compare(this.start, o.start);
        	}
        	return result;
        }

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + "]";
		}
        
        
    }
    
    static boolean compCourse(Course a, Course b) {
    	if(a==null) {
    		return false;
    	}
    	if(a.end <= b.start) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Course> pq = new PriorityQueue<>();
        Course [] arr = new Course[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i]= new Course(start,end);
        }
        Arrays.sort(arr,(o1,o2)->o1.start-o2.start);
        for(int i=0; i<n; i++) {
        	if(compCourse(pq.peek(),arr[i])) {
        		pq.poll();
        	}
        	pq.add(arr[i]);
        }
        System.out.println(pq.size());
    }

}