package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_081_68936 {
    public int[] solution(int[][] arr) {
        List<Array2D> array2DList = new ArrayList<>();
        array2DList.add(new Array2D(arr));

        int n = arr.length / 2;
        while (n > 0) {
            Array2D array2D = new Array2D(n, n);
            array2D.fill(-1);
            array2DList.add(array2D);
            n /= 2;
        }

        for (int i = 0; i < array2DList.size() - 1; i++) {
            Array2D prev = array2DList.get(i);
            Array2D next = array2DList.get(i + 1);
            for (int y = 0; y < prev.height; y += 2) {
                for (int x = 0; x < prev.width; x += 2) {
                    arr = prev.arr;
                    // 이전 값 중 -1 이 한 개라도 있으면 압축이 안 됨
                    if (arr[y][x] == -1 || arr[y + 1][x] == -1 || arr[y][x + 1] == -1 || arr[y + 1][x + 1] == -1) {
                        continue;
                    }
                    // 4개의 값이 같으면 다음 결과에 압축 값을 저장하고 이전 값은 -1로 채운다.
                    if (arr[y][x] == arr[y + 1][x] && arr[y][x] == arr[y + 1][x + 1] && arr[y][x] == arr[y][x + 1]) {
                        next.arr[y / 2][x / 2] = arr[y][x];
                        arr[y][x] = -1;
                        arr[y + 1][x] = -1;
                        arr[y][x + 1] = -1;
                        arr[y + 1][x + 1] = -1;
                    }
                }
            }
        }

        return array2DList.stream().map(this::count0And1).reduce((x, y) -> new int[]{x[0] + y[0], x[1] + y[1]}).orElse(new int[]{0, 0});
    }

    public int[] count0And1(Array2D arr) {
        int count0 = 0;
        int count1 = 0;
        for (int y = 0; y < arr.height; y++) {
            for (int x = 0; x < arr.width; x++) {
                if (arr.arr[y][x] == 0) {
                    count0++;
                } else if (arr.arr[y][x] == 1) {
                    count1++;
                }
            }
        }
        return new int[]{count0, count1};
    }

    static class Array2D {
        int[][] arr;
        int height;
        int width;

        public Array2D(int width, int height) {
            arr = new int[height][width];
            this.height = height;
            this.width = width;
        }

        public Array2D(int[][] o) {
            this.height = o.length;
            if (height == 0) {
                throw new RuntimeException("Width can't be 0");
            }
            this.width = o[0].length;
            arr = new int[height][width];
            IntStream.range(0, height).forEach(y -> System.arraycopy(o[y], 0, arr[y], 0, width));
        }

        public void fill(int value) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    arr[y][x] = value;
                }
            }
        }
    }
}
