import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		int cnt=0;
		for(int i=0; i<n; i++) {
			arr[i]=i+1;
		}
		
		int start=0, end=0;
		while(start < n) {
			int sum=0;
			for(int i=start; i < end; i++) {
				sum+=arr[i];
			}
			if(sum == n) {
				cnt++;
				start++;
			}
			
			if(sum < n) {
				end++;
			}
			else if(sum > n) {
				start++;
			}
			
		}
		System.out.println(cnt);
	}

}
