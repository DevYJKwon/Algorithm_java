import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11729 {
	static StringBuilder sb = new StringBuilder();
	static void hanoi(int n,int from, int mid , int to) {
		if(n==1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		hanoi(n-1,from,to,mid);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n-1,mid,from,to);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb.append((int)Math.pow(2, n)-1).append("\n");
		hanoi(n,1,2,3);
		System.out.println(sb);
	}
}	
