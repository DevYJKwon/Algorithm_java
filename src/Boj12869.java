import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj12869 {
    static int dp [][][];
    static void bfs(int [] start){
        Queue<int[]> q  = new ArrayDeque<>();

        int d[][] = {{9,3,1},{9,1,3},{1,3,9},{1,9,3},{3,1,9},{3,9,1}};

        q.add(start);
        while(!q.isEmpty()){
            int [] cur = q.poll();
            if(cur[0] == 0 && cur[1]==0 && cur[2]==0){
                return;
            }

            for(int i=0; i<6; i++){
                int [] attack = d[i];
                int [] next = new int [3];
                for(int j=0; j<3; j++){
                    next[j]=cur[j]-attack[j];
                    if(next[j] < 0){
                        next[j]=0;
                    }
                }
                if(dp[next[0]][next[1]][next[2]]==0){
                    q.add(next);
                    dp[next[0]][next[1]][next[2]]= dp[cur[0]][cur[1]][cur[2]]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int scv[] = new int [3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            scv[i]=Integer.parseInt(st.nextToken());
        }
        dp = new int [scv[0]+1][scv[1]+1][scv[2]+1];
        bfs(scv);
        System.out.println(dp[0][0][0]);
    }
}
