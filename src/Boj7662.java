import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase= Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer,Integer> map = new TreeMap<>();

		for(int t=0; t<testCase; t++) {
			map.clear();
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if(cmd == 'I') {
					if(map.containsKey(num)) {
						map.put(num, map.get(num)+1);
					}
					else {
						map.put(num, 1);
					}
				}
				else {
					if(map.size()>0) {
						if(num==1) {
							int r = map.lastKey();
							if(map.get(r)==1) {
								map.remove(r);
							}
							else {
								map.put(r, map.get(r)-1);
							}
						}
						else {
							int r= map.firstKey();
							if(map.get(r)==1) {
								map.remove(r);
							}
							else {
								map.put(r, map.get(r)-1);
							}
						}
					}
				}
			}
			if(map.size()==0) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(map.lastKey()+" "+map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
