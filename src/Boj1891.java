import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1891 {
	static String str;
	static long fX, fY;
	static int size;
	static StringBuilder sb = new StringBuilder();

	static void getPos(int n, long x, long y, long width) {
		if (n == size) {
			fX = x;
			fY = y;
			return;
		}
		int num = str.charAt(n)-'0';
		long half=width/2;
		switch(num) {
		case 1:
			getPos(n+1,x+half,y,half);
			break;
		case 2:
			getPos(n+1,x,y,half);
			break;
		case 3:
			getPos(n+1,x,y+half,half);
			break;
		case 4:
			getPos(n+1,x+half,y+half,half);
			break;
		}
	}
	
	static void getNum(int n ,long x, long y, long width) {
		if (n == size) {
			return;
		}
		long half = width/2;
		if(x >= half && y< half) { //1사분면
			sb.append("1");
			getNum(n+1,x-half,y,half);
		}
		else if(x <half && y < half) { //2
			sb.append("2");
			getNum(n+1,x,y,half);
		}
		else if(x <half && y >= half) {
			sb.append("3");
			getNum(n+1,x,y-half,half);
		}
		else {
			sb.append("4");
			getNum(n+1, x-half, y-half, half);
		}

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken()); // 몇 번 나눌지
		str = st.nextToken();
		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken())*-1; //위가 음수
		long width = 1l<<size;
		getPos(0,0,0,width);
		fX+=x;
		fY+=y;
		if(fX >= 0 && fY >=0 && fX < width && fY <width) {
			getNum(0,fX,fY,width);
		}
		else {
			sb.append("-1");
		}
		System.out.println(sb);
	}

}
