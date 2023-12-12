import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17281 {
	static int n,max=0;
	static int [][] game;
	static int [] player = {0,1,2,3,4,5,6,7,8};
	static int hitTheBall(boolean [] field, int type) {
		int score=0;
		for(int i=3; i>=0; i--) {
			if(field[i] && i+type > 3) {
				field[i]=false;
				score++;
			}
			else if(field[i] && i+type <= 3) {
				field[i]=false;
				field[i+type]=true;
			}
		}
		return score;
	}
	static void permutation(int nth,int [] chosen, boolean [] visited) {
		if(nth == chosen.length) {
			int score =0;
			int outCnt=0;
			int j=0;
			for(int i=0; i<n; i++) {
				outCnt=0;
				boolean [] field = new boolean [4]; //0:Å¸¼®, 1:1·ç, 2:2·ç, 3:3·ç
				while(outCnt<3) {
					field[0]=true;
					int play = game[i][chosen[j]];
					if(play==0) {
						outCnt++;
					}else {
						score += hitTheBall(field,play);
					}
					j=++j%9;
				}
			}
			max =Math.max(max, score);
			return;
		}
		for(int i=0; i<9; i++) {
			if(nth == 4) {
				if(chosen[3]!=0) {
					return;
				}
			}
			if(!visited[i]) {
				visited[i]=true;
				chosen[nth]= player[i];
				permutation(nth+1, chosen, visited);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // ÀÌ´× È½¼ö
		StringTokenizer st;
		game = new int [n][9];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				game[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		permutation(0,new int [9] ,new boolean[9]);
		System.out.println(max);
	}
}
