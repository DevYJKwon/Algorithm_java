import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2231 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=n/2; i<=n ; i++) {
			int sum=i;
			String str = Integer.toString(i);
			for(char c: str.toCharArray()) {
				sum+= c-'0';
			}
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

}
