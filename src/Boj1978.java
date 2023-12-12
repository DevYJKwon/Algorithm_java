import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1978 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			boolean flag = true;
			int num = Integer.parseInt(st.nextToken());
			if(num==1) {
				continue;
			}
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num%j==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
