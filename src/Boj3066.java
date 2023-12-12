import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3066 {
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
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			lis = new int [n];
			int len=0;
			lis[len]= Integer.parseInt(br.readLine());
			for(int i=1; i<n; i++) {
				int next = Integer.parseInt(br.readLine());
				if(lis[len] < next) {
					lis[++len]=next;
				}
				else {
					int idx = binarySearch(0,len,next);
					lis[idx]=next;
				}
			}
			if(len ==0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(len+1).append("\n");			
			}
		}
		System.out.println(sb);
	}

}
