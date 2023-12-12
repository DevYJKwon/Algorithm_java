import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3040 {
	static int [] arr;
	static int [] res;
	static void comb(int n, int start, int [] choosed) {
		if(n == choosed.length) {
			int sum=0;
			for(int i=0; i<choosed.length;i++) {
				sum+=choosed[i];
			}
			if(sum==100) {
				for(int i=0; i<choosed.length;i++) {
					res[i]=choosed[i];
				}	
			}
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			choosed[n]=arr[i];
			comb(n+1,i+1,choosed);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int [9];
		res = new int [7];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0,new int [7]);
		
		for(int i=0; i<7; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
