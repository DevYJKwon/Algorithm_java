import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {
	static BufferedWriter bw;
	static void np(int nth, int res) {
		if(nth == n) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		for(int i=0; i<4; i++) {
			int r = getRes(res,nums[nth],i);
			if(r != FAIL) {
				np(nth+1,r);
				ops[i]++;
			}
		}
	}
	static int getRes(int a, int b, int op) {
		if(ops[op] == 0) {
			return FAIL;
		}
		ops[op]--;
		if(op == 0) {
			return a+b;
		}
		else if(op==1) {
			return a-b;
		}
		else if(op==2) {
			return a*b;
		}
		else {
			return a/b;
		}
	}
	static char [] op = {'+','-','*','/'};
	static final int FAIL=1100000000;
	static int max= -100000001, min = Integer.MAX_VALUE;
	static int [] nums;
	static int [] ops;
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums=new int[n];
		ops=new int [4];
		for(int i=0; i<n; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			ops[i]=Integer.parseInt(st.nextToken());
		}
		np(1,nums[0]);
		System.out.println(max);
		System.out.println(min);
	}

}
