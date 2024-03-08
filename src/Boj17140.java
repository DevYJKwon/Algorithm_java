import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17140 {
    static int[][] map = new int[100][100];
    static int maxR = 3, maxC = 3;

    static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) {
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.cnt,o.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int y = 0; y < 3; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 3; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;
        while (t <= 100) {
            if (map[r][c] == k) {
                break;
            }

            if (maxR >= maxC) {
                // r 연산
                for (int y = 0; y < maxR; y++) {
                    PriorityQueue<Node> pq = new PriorityQueue<>();
                    int [] num = new int [101];
                    for (int x = 0; x < maxC; x++) {
                        if (map[y][x] != 0) {
                            num[map[y][x]]++;
                        }
                    }
                    for (int i=1; i<=100; i++) {
                        if(num[i]>0){
                            pq.add(new Node(i, num[i]));
                        }
                    }
                    maxC = Math.max(maxC, pq.size() * 2);
                    int x = 0;
                    while (!pq.isEmpty()) {
                        if(x>=99){
                            break;
                        }
                        Node cur = pq.poll();
                        map[y][x++]=cur.num;
                        map[y][x++]=cur.cnt;
                    }

                    for (; x < maxC; x++) {
                        map[y][x] = 0;
                    }
                }
            } else {
                // c 연산
                for (int x = 0; x < maxC; x++) {
                    PriorityQueue<Node> pq = new PriorityQueue<>();
                    int [] num = new int [101];
                    for (int y = 0; y < maxR; y++) {
                        if (map[y][x] != 0) {
                            num[map[y][x]]++;
                        }
                    }

                    for (int i=1; i<=100; i++) {
                        if(num[i]>0){
                            pq.add(new Node(i, num[i]));
                        }
                    }

                    maxR = Math.max(maxR, pq.size() * 2);
                    int y = 0;
                    while (!pq.isEmpty()) {
                        if(y>=99){
                            break;
                        }
                        Node cur = pq.poll();
                        map[y++][x]=cur.num;
                        map[y++][x]=cur.cnt;
                    }

                    for (; y < maxR; y++) {
                        map[y][x] = 0;
                    }
                }
            }
            t++;
        }
        if(t>100){
            t=-1;
        }
        System.out.println(t);
    }
}
