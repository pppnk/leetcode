//We are given a binary matrix and it is guaranteed that a one will not be followed by a zero in a row. Return the leftmost column index with a one in it.
//[0 0 0 1]
//[0 0 1 1]
//[0 1 1 1]
//[0 0 0 0]
public class FindLeftmost {
    public static int findLeftmostIndexOfOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int candidate = -1;
        for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
            if (matrix[r][c] == 1) {
                candidate = c;
                c--;
            } else {
                r++;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(findLeftmostIndexOfOne(matrix)); // 1

        int[][] matrix2 = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        System.out.println(findLeftmostIndexOfOne(matrix2)); // -1

        int[][] matrix3 = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}};

        System.out.println(findLeftmostIndexOfOne(matrix3)); // 3
    }
}
