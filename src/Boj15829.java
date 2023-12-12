import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15829 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int m = 1234567891;
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();

		long r = 1;
		long res=0;
		for(int i=0; i<len; i++) {
			char c = str.charAt(i);
			res+= (c-96)%m*r%m;
			r = r%m*31;
		}
		res%=m;
		System.out.println(res);
		
	}

}
