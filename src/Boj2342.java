import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2342 {

	/*
	 * 중앙에 있던 발이 다른 곳으로 가면 2의 힘 다른 지점에서 인접한 곳으로 갈 땐 3의 힘 반대편으로 이동하면 4의 힘
	 */
	static int power(int pos, int target) {
		int dis = Math.abs(pos - target);
		if (pos == 0) {
			return 2;
		} else if (dis == 0) {
			return 1;
		} else if (dis==2) {
			return 4;
		} else {
			return 3;
		}
	}
	static int dfs(int nth, int l, int r) {
		if(nth == steps.size()) {
			return 0;
		}
		int cur = l+r;
		if(dp[nth][cur]!=0) {
			return dp[nth][cur];
		}
		int next = steps.get(nth);


		dp[nth][cur] = Math.min(dfs(nth+1,next,r)+power(l,next),dfs(nth+1,l,next)+power(r,next));

		return dp[nth][cur];
		
	}
	static int [][] dp;
	static List<Integer> steps = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (true) {
			int step = Integer.parseInt(st.nextToken());
			if (step == 0) {
				break;
			}
			steps.add(step);
		}
		dp = new int [steps.size()][32];
		
		int res= dfs(0,0,0);
		System.out.println(res);
	}

}
