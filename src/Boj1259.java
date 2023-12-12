import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1259 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		real:while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n== 0) {
				break;
			}
			String str = Integer.toString(n);
			String pre = str.substring(0,(str.length()+1)/2);
			String post = str.substring(str.length()/2);
			for(int i=0; i<pre.length(); i++) {
				if(pre.charAt(i) != post.charAt(post.length()-i-1)) {
					sb.append("no\n");
					continue  real;
				}
			}
			sb.append("yes\n");
		}
		// TODO Auto-generated method stub
		System.out.println(sb);
	}

}
