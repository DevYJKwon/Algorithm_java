import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea6808 {
	/*
	 * 18장을 각각 9장씩 나눈다.
	 * 각 1장씩 뽑고 큰 사람은 두 카드의 수를 합한 만큼 증가, 작은 사람은 아무런 변화 x
	 * 규영이의 카드는 고정 
	 * 인영이가 어떻게 내는냐에 따라 승패가 결정된다.
	 * 이기는 경우와 지는 경우가 몇 개인가?
	 * 
	 * 첫 번째 줄 테스트케이스 수 
	 * 각 줄 마다 9카드
	 * 
	 * 순열로 인영이 카드 덱의 경우의 수를 모두 받아서 승 패에 따라 카운팅
	 */
	
	static int win,lose;
	static int [] card = new int[9];
	static int [] card2 = new int[9];
	
	static boolean np() {
		int lastPeak = card2.length-1;
		while(lastPeak>0 && card2[lastPeak-1] >= card2[lastPeak]) {
			lastPeak--;
		}
		if(lastPeak==0) { 
			return false;
		}
		int nextBoss = card2.length-1;
		while(card2[lastPeak-1] >= card2[nextBoss]) { 
			nextBoss--;
		}
		swap(card2,nextBoss,lastPeak-1);
		for(int left=lastPeak, right=card2.length-1; left<right; left++,right--) {
			swap(card2,left,right);
		}
		return true;
	}
	static void swap(int[]arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b]= temp;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean [] total = new boolean [19];
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(total, true);
			for(int i=0; i<9; i++) {
				card[i]=Integer.parseInt(st.nextToken());
				total[card[i]]= false;
			}
			int index=0;
			for(int i=1; i<=18; i++) {
				if(total[i]) {
					card2[index++]=i;
				}
			}
			Arrays.sort(card2);
			win=0;
			lose=0;
			do {
				int p1=0,p2=0;
				for(int i=0; i<9; i++) {
					if(card[i] > card2[i]) {
						p1+= card[i]+card2[i];
					}
					else if(card[i] < card2[i]) {
						p2+= card[i]+card2[i];
					}
				}
				if(p1 > p2) {
					win++;
				}
				else if(p1 < p2) {
					lose++;
				}
			}while(np());
			
			sb.append(String.format("#%d %d %d\n", t,win,lose));
		}
		System.out.println(sb);
	}

}
