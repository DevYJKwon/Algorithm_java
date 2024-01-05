import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2580 {
    static int map[][] = new int[9][9];
    static ArrayList<Point> arr = new ArrayList<>();

    static void play(int i) {
        if (i == arr.size()) {
            print();
        }

        Point pos = arr.get(i);
        int x = pos.x;
        int y = pos.y;

        for (int j = 1; j <= 9; j++) {
            if (check(x, y,j)) {
                map[y][x]=j;
                play(i + 1);
                map[y][x]=0;
            }
        }
    }

    static boolean check(int x, int y,int target) {
        //가로 세로 체크
        for (int i = 0; i < 9; i++) {
            if (map[y][i] == target || map[i][x]==target) {
                return false;
            }
        }

        //3x3 체크
        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for (int i = startX; i<startX+3 ; i++) {
            for (int j = startY; j < startY+3; j++) {
                if (map[j][i] == target) {
                    return false;
                }
            }
        }

        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 0) {
                    arr.add(new Point(j, i));
                }
                map[i][j] = tmp;
            }
        }
        play(0);
    }
}
