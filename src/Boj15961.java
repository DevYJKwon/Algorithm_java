import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj15961 {
	/*
	 * 먹을 수 있는 초밥의 최대 가짓수를 구하라.
	 * 
	 * 벨트에 놓인 초밥의 수 n , 초밥의 가짓수 d , 연속해서 먹는 접시 수 k, 쿠폰 번호 c
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] q = new int[n + k];
		Deque<Integer> ate = new ArrayDeque<>();
		int[] has = new int[d + 1];

		for (int i = 0; i < n; i++) {
			q[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			ate.addFirst(q[i]);
			has[q[i]]++;
			q[i + n] = q[i];
		}
		int kind = 0,max=0;
		for (int i = 1; i < has.length; i++) {
			if (has[i] > 0) {
				kind++;
			}
		}
		max = kind;
		if (has[c] == 0) {
			kind++;
			max = kind;
			kind--;
		}
		
		for (int i = k; i < q.length; i++) {
			int dish = q[i];
			int out = ate.removeLast();
			ate.addFirst(dish);
			has[out]--;
			if (has[out] == 0) {
				kind--;
			}
			has[dish]++;
			if (has[dish] == 1) {
				kind++;
			}
			if (has[c] == 0) {
				kind++;
				max = Math.max(max, kind);
				kind--;
				continue;
			}
			max = Math.max(max, kind);
		}
		System.out.println(max);

	}

}