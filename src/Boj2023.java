import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2023 {
	static void dfs(int nth, int num) {
		if(!isPrime(num)) {
			return;
		}
		if(nth==n-1) {
			sb.append(num).append("\n");
			return;
		}
		int next = num*10;
		for(int i=0; i<end.length; i++) {
			dfs(nth+1,next+end[i]);
		}
	}
	static boolean isPrime(int num) {
		for(int i=2; i*i<num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int [] start = {2,3,5,7};
	static int [] end = {1,3,7,9};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int num : start) {
			dfs(0,num);
		}
		System.out.println(sb);
	}

}
