import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int l,c;
	static String vowel = "aeiou";
	static StringBuilder sb= new StringBuilder();
	static char [] arr;
	
	static boolean isValid(char [] arr) {
		int vCnt=0,cCnt=0;
		for(int i=0; i<arr.length; i++) {
			if(vowel.contains(Character.toString(arr[i]))) {
				vCnt++;
			}
			else {
				cCnt++;
			}
		}
		if(vCnt>=1 && cCnt>=2) {
			return true;
		}
		else {
			return false;
		}
	}
	static void comb(int nth, int start, char [] chosen) {
		if(nth == chosen.length) {
			if(isValid(chosen)) {
				for(int i=0; i<chosen.length; i++) {
					sb.append(chosen[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start; i <c; i++) {
			chosen[nth]=arr[i];
			comb(nth+1,i+1,chosen);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken()); // 만들 길이
		c = Integer.parseInt(st.nextToken());
		arr = new char [c];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i]= st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		comb(0,0,new char[l]);
		System.out.println(sb);
	}

}
