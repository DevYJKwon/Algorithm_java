import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Food{
	int cal;
	int score;
	
	Food(int score, int cal){
		this.cal = cal;
		this.score = score;
	}
}
public class Swea5215 {
	static int maxScore,limit;
	static Food [] list;
	
	/*
	 * 음식 재료별 점수를 매김
	 * 정해진 칼로리 안에서 점수가 높은 조합을 찾아라
	 */
	static void subset(int r, boolean [] choosed,int score,int cal) {
		if(r == choosed.length) {
			if(score > maxScore && limit >= cal) {
				maxScore = score;
			}
			return;
		}
		
		choosed[r]=false;
		subset(r+1, choosed,score,cal);
		if(cal+list[r].cal <= limit) {
			choosed[r]=true;
			subset(r+1, choosed,score+list[r].score,cal+list[r].cal);
		}
	}
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			list = new Food [n] ;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			maxScore=0;
			subset(0,new boolean[n],0,0);
			sb.append(String.format("#%d %d\n", t,maxScore));
		}
		System.out.println(sb);
	}

}
