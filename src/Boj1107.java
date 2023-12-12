import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1107 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int [] numBtn = {0,1,2,3,4,5,6,7,8,9}; 
		if(n!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int loss = Integer.parseInt(st.nextToken());
				numBtn[loss]=-1;
			}
		}
		int res1 = Integer.MAX_VALUE;
		outer:for(int i=0; i<999901; i++) {
			String str = Integer.toString(i);
			for(int s=0; s<str.length(); s++) {
				if(numBtn[str.charAt(s)-'0']==-1) {
					continue outer;
				}
			}
			res1 = Math.min(res1, Math.abs(Integer.parseInt(target)-i)+str.length());
		}
		
		int res2 = Math.abs(Integer.parseInt(target) - 100);
		System.out.println(Math.min(res1, res2));
	}

}
