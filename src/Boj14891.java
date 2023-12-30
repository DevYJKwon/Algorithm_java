import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj14891 {
	static Deque<Character> gear[] = new ArrayDeque[5];
	
	//시계 last pop -> first
	//반시계 first pop -> last
	static void cw(int n) {
		char tmp = gear[n].pollLast();
		gear[n].addFirst(tmp);
	}
	
	static void ccw(int n) {
		char tmp = gear[n].pollFirst();
		gear[n].addLast(tmp);
	}
	
	static void checkLeft(int n,char tl, int dir) {
		
		int left = n-1;
		if(left >= 1) {
			char lr = gear[left].toString().charAt(7);
			char ll = gear[left].toString().charAt(19);
			if(tl != lr) {
				if(dir==1) {
					ccw(left);
				}
				else {
					cw(left);
				}
				checkLeft(left,ll,dir==1? 0:1);
			}
		}

	}
	
	static void checkRight(int n,char tr , int dir) {
		
		int right = n+1;
		if(right <= 4) {
			char rl = gear[right].toString().charAt(19);
			char rr = gear[right].toString().charAt(7);
			if(tr != rl) {
				if(dir==1) {
					ccw(right);
					
				}
				else {
					cw(right);
				}
				checkRight(right,rr,dir==1? 0:1);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<5; i++) {
			gear[i]= new ArrayDeque<>();
		}
		 //N = 0 , S= 1 
		for(int i=1; i<5; i++) {
			String tmp = br.readLine();
			for(char c : tmp.toCharArray()) {
				gear[i].addLast(c);
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 1 시계,  -1 반시계
			
			//인접한 톱니 체크
			char tl = gear[target].toString().charAt(19);
			char tr = gear[target].toString().charAt(7);
			checkLeft(target,tl,dir);
			checkRight(target,tr,dir);
			
			if(dir == 1) {
				cw(target);
			}
			else {
				ccw(target);
			}
			
		}
		
		//first 값 보고 1 이면 2^n-1
		int sum =0;
		for(int i=1; i<5; i++) {
			if(gear[i].getFirst() == '1') {
				sum += Math.pow(2, i-1);
			}
		}
		System.out.println(sum);
		
	}

}
