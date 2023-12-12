import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> pwd = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		// 총 문자열 s 부분문자열 p
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char [] acgt = {'a','c','g','t'};
		int cnt = 0;
		// 문자열
		String str = br.readLine();
		int len = s-p;
		// ACGT 각 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			 int n = Integer.parseInt(st.nextToken());
			 map.put(acgt[i], n);
		}
		
		int i=0;
		while (i < len) {
			int l = i++;
			int h = i+len;
			boolean flag = true;
			HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();
			for(int idx=l; idx<h; idx++) {
				
				if(temp.get(str.charAt(idx)) > 0) {
					temp.put(str.charAt(idx), temp.get(str.charAt(idx))-1);
				}
				else {
					flag= false;
					break;
				}
			}
			if(flag) {
				pwd.add(str.copyValueOf(str.toCharArray(), l, h));
			}
		}
		System.out.println(pwd.size());
	}

}
