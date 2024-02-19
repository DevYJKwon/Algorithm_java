import java.util.*;
import java.io.*;
public class Boj2016 {
    static int[][] prefer = new int[11][5];
    static int [] num = new int[]{6,7,8,9,10};

    static int origin;
    static boolean isYes;

    static int matching(int[] arr){

        for(int i=0; i<5; i++){
            prefer[1][i]=arr[i];
        }

        PriorityQueue<Integer> girls = new PriorityQueue<>();
        for(int i=6; i<=10; i++){
            girls.add(i);
        }
        int[] boys = new int[6];
        while(!girls.isEmpty()){

            int curGirl = girls.poll();
            for(int i=0; i<5; i++){
                int curBoy =prefer[curGirl][i];
                if(boys[curBoy] == 0){
                    boys[curBoy]=curGirl;
                    break;
                }

                List<Integer> list = new ArrayList<>();
                for(int a=0; a<5; a++){
                    list.add(prefer[curBoy][a]);
                }
                if(list.indexOf(boys[curBoy]) > list.indexOf(curGirl)){
                    girls.add(boys[curBoy]);
                    boys[curBoy]=curGirl;
                    break;
                }
            }
        }
        return boys[1];
    }

    static void np(int nth, int [] chosen, boolean [] visited){
        if(isYes){
            return;
        }
        if(nth==chosen.length){
            int res = matching(chosen);
            if(res < origin){
                isYes=true;
            }
            return;
        }

        for(int i=0; i<5; i++){
            if(!visited[i]){
                chosen[nth]=num[i];
                visited[i]=true;
                np(nth+1,chosen,visited);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            isYes=false;
            for(int i=2; i<=10; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++){
                    prefer[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            origin = matching(new int[]{6, 7, 8, 9, 10});

            np(0,new int[5], new boolean[5]);

            if(isYes){
                sb.append("YES");
                sb.append("\n");
                continue;
            }
            sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
