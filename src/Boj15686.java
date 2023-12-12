import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686 {
	/*
	 * NxN 도시 각 도시의 1칸은 빈 집 0, 집 1, 치킨집 2 (r,c) => (y,x) 각 집에서 가장 가까운 치킨집의 거리 = 치킨거리
	 * 도시의 모든 치킨거리의 합 = 도시의 치킨거리 두 노드의 거리는 |r1-r2| + |c1-c2| 치킨 가게의 최대 개수는 M 나머지는 폐업
	 * 어떤 가게를 폐업 시켜야 도시의 치킨거리가 가장 작아지는가?
	 * 
	 * 첫째 줄 N,M
	 * 
	 * 13Cm 조합을 구해서 최소가 되는 경우를 출력
	 */
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static List<Point> house = new ArrayList<>();
	static List<Point> shop = new ArrayList<>();

	static void comb(int nth, int start, Point[] choosed) {
		if (nth == choosed.length) {
			int[] cDistance = new int[house.size()];
			Arrays.fill(cDistance, Integer.MAX_VALUE);
			int sum = 0;

			for (int i = 0; i < choosed.length; i++) {
				for (int j = 0; j < house.size(); j++) {
					cDistance[j] = Math.min(getDistance(house.get(j), choosed[i]), cDistance[j]);
				}
			}

			for (int i = 0; i < cDistance.length; i++) {
				sum += cDistance[i];
			}
			min = Math.min(sum, min);
			return;
		}

		for (int i = start; i < shop.size(); i++) {
			choosed[nth] = shop.get(i);
			comb(nth + 1, i + 1, choosed);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());

		map = new int[size][size];

		for (int y = 0; y < size; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < size; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2) {
					shop.add(new Point(x, y));
				} else if (map[y][x] == 1) {
					house.add(new Point(x, y));
				}
			}
		}

		comb(0, 0, new Point[limit]);
		System.out.println(min);
	}

	static int getDistance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
