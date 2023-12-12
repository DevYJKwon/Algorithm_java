import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Course implements Comparable<Course>{
	int num;
	int start;
	int end;
	
	
	public Course(int num, int start, int end) {
		this.num = num;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Course o) {
		return Integer.compare(this.end, o.end);
	}
}
public class Boj1379 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Course [] arr = new Course [n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i]=new Course(i,start,end);
		}
		
		
	}

}
