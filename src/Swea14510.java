import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Swea14510 {
	static boolean isDone(Integer [] trees) {
		for(int i=1; i<trees.length; i++) {
			if(trees[0] != trees[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Integer [] trees;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			trees = new Integer [n];
			int day=0;
			int cnt=0;
			for(int i=0;i<n; i++) {
				trees[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(trees,Collections.reverseOrder());
			int goal = trees[0];
			int odd=0;
			int even=0;
			int d=0;
			for(int i=1; i<n;i++) {
				int diff = goal- trees[i];
				odd += diff%2;
				even += diff/2;
			}
			while(odd > 0 || even >0) {
				if(day==0) {
					if(odd>0) {
						odd--;
					}
					else if(even >0) {
						if(++d==2) {
							even--;
							d=0;
						}
					}
				}
				else {
					if(even >0) {
						even--;
					}
				}
				day= (day+1)%2;
				cnt++;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
