import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
	static int cnt = 0, r, c;

	static void getHalf(int sr, int sc, int size) {
		int half = size / 2;
		if(half ==0) {
			return;
		}
			if (sr >= half && sc >= half) {
				getHalf(sr-(int)Math.pow(2, half), sc-(int)Math.pow(2, half), half);
				cnt += Math.pow(2, half) * 3;
			} else if (sr >= half && sc < half) {
				getHalf(sr-(int)Math.pow(2, half), sc, half);
				cnt += Math.pow(2, half) * 2;
			} else if (sr < half && sc >= half) {
				getHalf(sr, sc-(int)Math.pow(2, half), half);
				cnt += Math.pow(2, half) * 1;
			} else if (sr < half && sc < half) {
				getHalf(sr, sc, half);
			}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		getHalf(r, c, (int)Math.pow(2, n));
		System.out.println(cnt);
	}

}
