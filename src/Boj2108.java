import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Boj2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map =new TreeMap<>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());

			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}
			else {
				map.put(num, 1);
			}
		}
		
		int sum=0;
		int cnt=0;
		int median = 0;
		int mode =5000;
		boolean isSecond = false;
		for(Entry<Integer, Integer>entry:map.entrySet()) {
			sum+= entry.getKey()*entry.getValue();
			//최빈값
			if(mode==5000) {
				mode = entry.getKey();
			}
			else if(map.get(mode) < entry.getValue()) {
				mode = entry.getKey();
				isSecond=false;
			}
			else if(map.get(mode) == entry.getValue() && !isSecond) {
				isSecond= true;
				mode = entry.getKey();
			}
			//중앙값
			if(cnt < n/2+1 && (cnt+entry.getValue() >= n/2+1)) {
				median = entry.getKey();
			}
			cnt+=entry.getValue();
		}
		//산술 평균
		int arithMean = (int) Math.round((double)sum / n);

		
		//범위
		int range = Math.abs(map.lastKey() - map.firstKey());
		sb.append(arithMean).append("\n");
		sb.append(median).append("\n");
		sb.append(mode).append("\n");
		sb.append(range).append("\n");
		System.out.println(sb);
	}

}
