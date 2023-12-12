import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int [n];
		int sum =0;
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<k; i++) {
			sum +=arr[i];
		}
		int max = sum;
		for(int i=0; i<n-k; i++) {
			sum -=arr[i];
			sum += arr[i+k];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
