import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {
	/*
	 * 2^32 = 2^16 * 2^16
	 */
	static int e,n;
	static long d;
	static long div(int start, int exponent) {
		if(exponent == 1) {
			return start%d;
		}
		
		long res = div(start,exponent/2);
		if(exponent%2==0) {
			return ((res%d)*(res%d))%d;
		}
		else {
			return (((start%d)*(res%d))%d*(res%d))%d;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		System.out.println(div(n,e));
	}

}
