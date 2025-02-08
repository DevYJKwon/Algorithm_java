import java.util.*;
import java.io.*;

public class Boj14499 {
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    static int [] dy = {0,0,-1,1};
    static int [] dx = {1,-1,0,0};


    static class Dice{
        int [] list = new int [6];
        int y;
        int x;
        Dice(int startX, int startY){
            this.y=startY;
            this.x=startX;
        }

        void moveEast(){
            int temp = list[1];
            list[1]=list[4];
            list[4]=list[3];
            list[3]=list[5];
            list[5]=temp;
        }
        void moveWest(){
            int temp = list[1];
            list[1]=list[5];
            list[5]=list[3];
            list[3]=list[4];
            list[4]=temp;
        }
        void moveNorth(){
            int temp = list[0];
            list[0]=list[1];
            list[1]=list[2];
            list[2]=list[3];
            list[3]=temp;
        }
        void moveSouth(){
            int temp = list[3];
            list[3]=list[2];
            list[2]=list[1];
            list[1]=list[0];
            list[0]=temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int height= Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        Dice dice = new Dice(startX, startY);
        int [][] map= new int[height][width];

        int commandSize = Integer.parseInt(st.nextToken());

        for(int y=0; y<height; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<width; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(commandSize-- >0){
            int direction = Integer.parseInt(st.nextToken())-1;
            int nx = dice.x+dx[direction];
            int ny = dice.y+dy[direction];
            if(nx >=0 && ny >=0 && nx < width && ny < height){
                //주사위 이동
                dice.x = nx;
                dice.y = ny;

                //주사위 굴리기
                switch(direction){
                    case EAST:
                        dice.moveEast();
                        break;
                    case WEST:
                        dice.moveWest();
                        break;
                    case NORTH:
                        dice.moveNorth();
                        break;
                    case SOUTH:
                        dice.moveSouth();
                        break;
                }

                //주사위 변경
                if(map[ny][nx]==0){
                    map[ny][nx]=dice.list[3];
                }else{
                    dice.list[3]=map[ny][nx];
                    map[ny][nx]=0;
                }

                //맨 위 출력
                sb.append(dice.list[1]).append("\n");
            }

        }
        System.out.print(sb);
    }
}
