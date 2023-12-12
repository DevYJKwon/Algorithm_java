import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj19585 {
	
	static HashSet<String> set = new HashSet<>();
	static class Trie{
		Trie child[] = new Trie[26]; // a~z;
		boolean isLast = false;
		void add(String str) {
			Trie node = this;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(node.child[c-'a']!=null) {
					node = node.child[c-'a'];
				}
				else {
					node.child[c-'a']= new Trie();
					node = node.child[c-'a'];
				}
			}
			node.isLast=true;
		} 

		
		boolean check(String str) {
			Trie node =this;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(node.child[c-'a']!=null) {
					if(node.child[c-'a'].isLast && set.contains(str.substring(i+1))) {
						return true;
					}
					node = node.child[c-'a'];
				}
				else {
					break;
				}
			}
			
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			trie.add(str);
		}
		
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			set.add(str);
		}

		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String team = br.readLine();
			
			if(trie.check(team)) {
				sb.append("Yes").append("\n");
			}
			else {
				sb.append("No").append("\n");
			}
		}
		System.out.println(sb);
	}	

}
