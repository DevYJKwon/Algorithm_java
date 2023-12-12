import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==0 && b==0 && c==0) {
				break;
			}
			if(a > c) {
				int temp =a;
				a=c;
				c =temp;
			}
			if(b > c) {
				int temp = b;
				b = c;
				c = temp;
			}
			
			if(Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2))==Math.sqrt(Math.pow(c, 2))) {
				sb.append("right\n");
			}
			else {
				sb.append("wrong\n");
			}
		}
		System.out.print(sb);

	}

}
