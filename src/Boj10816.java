import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10816 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//카드가 -10,000,000 ~ 10,000,000개 이므로 20,000,001 개 배열 생성
		int [] pcard =  new int [10000000];
		int [] mcard = new int[10000001]; // 0도 처리할거라 1개  더 많음
		//상근이의 카드 숫자 받기
		int n =Integer.parseInt(br.readLine());
		// 상근이의 카드를 받고 해당 index에 카드 수 만큼 넣기 +면 10000000 더하기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				pcard[num-1]++;
			}
			else {
				mcard[num*-1]++;
			}
		}
		//찾아야하는 카드 수 받기
		int f = Integer.parseInt(br.readLine());
		//카드 받고 해당 인덱스 참조해서 stringbuilder에 넣기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<f; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >0) {
				sb.append(pcard[num-1]+" ");
				continue;
			}
			sb.append(mcard[num*-1]+" ");
		}
		System.out.print(sb);
	}

}
