import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea1225 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long start = System.currentTimeMillis();
		for(int t=1; t<=10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			Deque<Integer> q = new ArrayDeque<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sb.append("#"+t+" ");
			
			for(int d =0; d<8; d++) {
				q.addFirst(Integer.parseInt(st.nextToken()));
			}
			int mCnt=1; //마이너스 카운트
			while(true) {
				int num = q.removeLast();
				num = num-mCnt++;
				mCnt = mCnt == 6? 1:mCnt;
				if(num <= 0) {
					num = 0;
					q.addFirst(num);
					break;
				}
				q.addFirst(num);
			}
			while(!q.isEmpty()) {
				sb.append(q.removeLast()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
        long end = System.currentTimeMillis();
        System.out.println(1.0*(end - start)/1000);
	}	

}
//3.808

//23.574