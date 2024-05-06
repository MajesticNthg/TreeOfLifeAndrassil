public class Level1 {
    public static String [] TreeOfLife(int H, int W, int N, String [] tree) {
        int[][] copy = new int[H][W];

        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (tree[x].charAt(y) == '+') {
                    copy[x][y] = 1;
                } else {
                    copy[x][y] = 0;
                }
            }
        }

        for (int x = 0; x < N; x++) {
            even(copy, H, W, x);
        }

        String[] newTree = new String[tree.length];
        convert(copy, H, W, newTree);

        return newTree;
    }
    public static int[][] even (int[][] copy, int H, int W, int z) {
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                copy[x][y] += 1;
            }
        }
        if (z % 2 != 0) delete(copy, H, W);

        return copy;
    }
    public static int[][] delete (int[][] copy, int H, int W) {
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (copy[x][y] >= 3) {
                    copy[x][y] = 0;
                    if (x > 0) copy[x-1][y] = 0;
                    if (x < H - 1 && copy[x+1][y] <= 2) copy [x+1][y] = 0;
                    if (y > 0) copy[x][y-1] = 0;
                    if (y < W - 1 && copy[x][y+1] <= 2) copy[x][y+1] = 0;
                }
            }
        }
        return copy;
    }
    public static String[] convert (int[][] copy, int H, int W, String[] newTree) {
        for (int x = 0; x < H; x++) {
            StringBuilder s = new StringBuilder();
            for (int y = 0; y < W; y++) {
                if (copy[x][y] == 0) s.append('.');
                else s.append('+');
            }
            newTree[x] = s.toString();
        }
        return newTree;
    }
    public static void main(String[] args) {
        int H = 6;
        int W = 7;
        int N = 24;
        String[] tree = {".......","...+...","....+..",".......","++.....","++....."};
        System.out.println(TreeOfLife(H, W, N, tree));
    }
}

