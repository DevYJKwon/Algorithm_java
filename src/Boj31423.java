import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj31423 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] arr = new String[n+1];
        int [] next = new int[n+1];
        int [] last = new int [n+1];
        for(int i=1; i<=n; i++){
            arr[i]=br.readLine();
            next[i]=i;
            last[i]=i;
        }
        int index = 0;
        for(int i=1; i<=n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            next[last[from]] = to;
            last[from]=last[to];
            index = from;
        }
        StringBuilder sb =new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(arr[index]);
            index = next[index];
        }
        System.out.println(sb);
    }
}
