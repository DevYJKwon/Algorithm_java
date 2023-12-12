import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1783 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (n == 1) {
			System.out.println(1);
			return;
		} 
		if (n == 2) {
			if (m < 3) {
				System.out.println(1);
				return;
			}
			else if(m<5) {
				System.out.println(2);
				return;
			} else if (m < 7) {
				System.out.println(3);
				return;
			} else {
				System.out.println(4);
				return;
			}

		} 
		if(n>2) {
			if (m < 5) {
				System.out.println(m);
				return;
			} else if (m == 5) {
				System.out.println(4);
				return;
			} else {
				System.out.println(m - 2);
				return;
			}
		}
	}

}
