

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int[n+1];

		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int res=Integer.MAX_VALUE;
		int left=0, right=0;
		int sum=0;
		while(left <= n && right <= n) {
			if(sum < s) {
				sum += arr[right++];
			}
			else {
				res = Math.min(res, right-left);
				sum-=arr[left++];
			}
		}
		if(res == Integer.MAX_VALUE) {
			res=0;
		}
		System.out.println(res);
	}

}
