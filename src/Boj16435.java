import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16435 {

	/*
	 * 과일을 먹을 수록 길이가 1 늘어남
	 * 과일은 지상으로부터 hi만큼 떨어져 있다.
	 * 자신의 길이보다 작거나 같은 과일만 먹을 수 있다.
	 * 처음 길이가 l일 때 먹을 수 있는 최대 과일의 개수
	 * 과일의 개수  n 스네이크 초기길이 l
	 * 각 h 높이
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int [] h = new int[n];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(h);
		for(int i=0; i<h.length; i++) {
			if(h[i] <= l) {
				l++;
			}
		}
		System.out.println(l);
	}

}
