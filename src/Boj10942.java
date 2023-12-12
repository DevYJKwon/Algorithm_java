import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10942 {
	/* 
	 * 2차원 dp테이블 만들어서 x시작점 y끝점으로 펠린드롬인지 여부 저장
	*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int [][] dp = new int [n+1][n+1];
		int [] arr = new int [n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			for(int j=1; j<=i; j++) {
				//펠린드롬 체크
				int left=j, right=i;
				while(left < right) {					
					if(arr[left] == arr[right]) {
						left++;
						right--;
					}
					else {
						dp[j][i]=0;
						break;
					}
					
				}
				if(left >= right) {
					dp[j][i]=1;
				}
			}
		}
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[start][end]).append("\n");
		}
		System.out.println(sb);
	}

}
