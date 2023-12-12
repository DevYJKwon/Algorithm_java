import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2352 {
	static int binarySearch(int start, int end, int target) {
		while(start< end) {
			int mid = (start+end)/2;
			
			if(lis[mid] < target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	static int [] lis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		lis = new int [n];
		int len=0;
		lis[len]=Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(lis[len] < next) {
				lis[++len]=next;
			}
			else {
				int idx = binarySearch(0,len,next);
				lis[idx]=next;
			}
		}
		if(len ==0) {
			System.out.println(1);
		}
		else {
			System.out.println(len+1);			
		}
	}

}
