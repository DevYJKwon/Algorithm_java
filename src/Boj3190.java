import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3190 {
    static class Action {
        int time;
        char dir;

        public Action(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Snake{
        Deque<Point> body = new ArrayDeque<>();
        int dir =0; // 0 R 1 D 2 L 3 U

        public Snake() {
            body.add(new Point(0,0));
        }
    }

    static char map[][];
    static Queue<Action> actionQueue = new ArrayDeque();
    static Snake snake = new Snake();
    static int play(){

        int time=0;
        while (true) {
            time++;
            Point head = snake.body.getFirst();
            int dx=0;
            int dy=0;

            switch (snake.dir){
                case 0:
                    dx=1;
                    break;
                case 1:
                    dy=1;
                    break;
                case 2:
                    dx=-1;
                    break;
                case 3:
                    dy=-1;
                    break;
            }

            Point next = new Point(head.x+dx,head.y+dy);

            if(next.y >= 0 && next.x >=0 && next.y < map.length && next.x <map.length){
                if(map[next.y][next.x]!='a'){
                    if(map[next.y][next.x] != 's'){
                        Point prev = snake.body.removeLast();
                        map[prev.y][prev.x]='o';
                    }
                    else{
                        return time;
                    }
                }
            }
            else{
                return time;
            }

            snake.body.addFirst(next);
            map[next.y][next.x]='s';

            if(actionQueue.isEmpty()){
                continue;
            }
            Action nextAction = actionQueue.peek();
            if(nextAction.time == time){
                if(nextAction.dir == 'L'){ // 왼쪽으로 회전
                    snake.dir--;
                    if(snake.dir < 0){
                        snake.dir=3;
                    }
                }
                else{ // 오른쪽으로 회전
                    snake.dir++;
                    if(snake.dir > 3){
                        snake.dir=0;
                    }
                }
                actionQueue.poll();
            }
        }


    }
    public static void main(String[] args) throws IOException {
        /*게임 시작할 때 뱀은 맨 좌측 위에 위치
         * 뱀은 매초마다 이동
         * 머리가 이동 사과가 없으면 꼬리 없어짐
         * 이동경로가 주어질 때 언제 끝나는지 출력
         * L이면 왼쪽 90도 D이면 오른쪽 90도 회전
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine()); // size of board
        map = new char[size][size];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1] = 'a';
        }

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            actionQueue.add(new Action(t, d));
        }
        int time = play();
        System.out.println(time);
    }
}