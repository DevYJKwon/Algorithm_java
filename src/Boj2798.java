import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int [] num =  new int [n];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		int max =0;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1;j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					sum = num[i]+num[j]+num[k];
					
					if(sum <= goal && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}

}
