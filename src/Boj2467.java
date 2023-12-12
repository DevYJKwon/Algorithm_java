import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long [n];
		int l=-1,r=-1;
		long min = Long.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		for(int i=0; i<n-1; i++) {
			int start = i+1;
			int end = n-1;
			long target = arr[i]*-1;
			while(start <= end) {
				int mid = (start+end)/2;
				long sum = Math.abs(arr[i]+arr[mid]);
				if(min > sum) {
					min = sum;
					l=i;
					r=mid;
				}
				
				if(arr[mid] <= target) {
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
		}
		System.out.println(arr[l]+" "+arr[r]);
	}

}
