import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj16472 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int max =0;
        int size;
        int len=0;
        boolean[] visited;
        for(int l=0; l<str.length(); l++){
            size=0;
            len=0;
            visited = new boolean[26];
            for(int r=l; r<str.length(); r++){
                int cur = str.charAt(r)-'a';
                if(!visited[cur]){
                    if(++size > n){
                        break;
                    }
                    visited[cur] = true;
                }
                len++;
            }
            max = Math.max(max,len);
            if(max == str.length()){
                break;
            }
        }
        System.out.println(max);
    }
}
