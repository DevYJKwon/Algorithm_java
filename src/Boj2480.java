import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2480 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] num = new int [7];
		for(int i=0; i<3; i++) {
			num[Integer.parseInt(st.nextToken())]++;
		}
		int max =0;
		int res=0;
		
		for(int i=1; i<7; i++) {
			if(num[i]==3) {
				res = 10000+i*1000;
				break;
			}
			else if(num[i]==2) {
				res = 1000+i*100;
				break;
			}
			else if(num[i]==1){
				max = Math.max(max, i);
				res = max*100;
			}
		}
		System.out.println(res);
	}

}
