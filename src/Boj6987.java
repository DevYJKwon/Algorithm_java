import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Country{
	int win;
	int lose;
	int draw;
	
	public Country(int win, int lose, int draw) {
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}
	
	public int getSum() {
		return this.win+this.lose+this.draw;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %d %d", win,draw,lose);
	}
	
}
public class Boj6987 {
	
	/*
	 * 모든 나라의 승 패 무의 합이 같아야함
	 * 무를 한 곳이 있으면 다른 곳도 무가 있어야함
	 * 패의 합과 승의 합이 같아야함
	 */
	static Point[] vs = new Point[15];
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Country [] arr = new Country[6];
		int idx=0;
		for(int i=0; i<6; i++) {
			for(int j=i+1; j<6; j++) {
				vs[idx++] = new Point(i,j);
			}
		}
		
		for(int i=0; i<4; i++) {
			st= new StringTokenizer(br.readLine());
			flag = false;
			for(int c=0; c<6; c++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				arr[c]=new Country(win, lose, draw);
			}
			
			checkAvailable(0,'w',arr.clone());
			checkAvailable(0,'d',arr.clone());
			checkAvailable(0,'l',arr.clone());
			
			if(flag) {
				sb.append(1+" ");
				continue;
			}
			sb.append(0+" ");
			
		}
		System.out.println(sb);
	}	
	
	static void checkAvailable(int n, char result,Country [] arr) {
		Country[] a = arr.clone();
		if(n == vs.length) {
			int sum=0;
			for(int i=0; i<6; i++) {
				sum+=arr[i].getSum();
			}
			if(sum==0) {
				flag=true;
			}
			return;
		}
		switch(result) {
		case 'w':
			if(a[vs[n].x].win > 0 && a[vs[n].y].lose > 0) {
				a[vs[n].x].win--;
				a[vs[n].y].lose--;

				checkAvailable(n+1,'w',a.clone());
				checkAvailable(n+1,'l',a.clone());
				checkAvailable(n+1,'d',a.clone());
				a[vs[n].x].win++;
				a[vs[n].y].lose++;
			}
			else {
				return;
			}
			break;
		case 'l':
			if(a[vs[n].x].lose > 0 && a[vs[n].y].win > 0) {
				a[vs[n].x].lose--;
				a[vs[n].y].win--;
				checkAvailable(n+1,'w',a.clone());
				checkAvailable(n+1,'l',a.clone());
				checkAvailable(n+1,'d',a.clone());
				a[vs[n].x].lose++;
				a[vs[n].y].win++;
			}
			else {
				return;
			}
			break;
		case 'd':
			if(a[vs[n].x].draw > 0 && a[vs[n].y].draw > 0) {
				a[vs[n].x].draw--;
				a[vs[n].y].draw--;
				checkAvailable(n+1,'w',a.clone());
				checkAvailable(n+1,'l',a.clone());
				checkAvailable(n+1,'d',a.clone());
				a[vs[n].x].draw++;
				a[vs[n].y].draw++;
			}
			else {
				return;
			}
			break;
		}
	}

}
