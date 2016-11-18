package leetcode;

/**
 * 解题思路：
 * 遍历搜索，
 * 关键点：
 * 1 用一个27*9 的数组存储标记所有状态
 * 2 注意终止条件，如果结束了则不要搽除！！！
 */
public class SudokuSolver {

    private static final Integer LEN = 9;
    private static final Integer WID = 9;
    private static final Integer TOTAL = 81;
    public void solveSudoku(char[][] board) {
        if (board == null && board.length != LEN && board[0].length != WID ) return;
        char[][] symbol = new char[LEN*3][WID];
        int coverNum = 0;
        for (int i = 0; i < TOTAL; i++) {
            int curX = i / LEN;
            int curY = i % WID;
            if (board[curX][curY] != '.') {
                fillData(symbol, curX, curY, board[curX][curY] - '0' - 1, '.');
            }
        }
        calculate(board, symbol, 0);
    }

    public boolean calculate(char[][]board, char[][]symbol, int cur) {
        if (cur >= TOTAL) {
            return true;
        }
        boolean result = false;
        if (cur < TOTAL) {
            int curX = cur / LEN;
            int curY = cur % WID;
            if (board[curX][curY] == '.') {
                for (int i = 1; i <= 9; i++) {
                    if (check(symbol, curX, curY, i-1)) {
                        // fill with '.'
                        fillData(symbol, curX, curY, i-1, '.');
                        board[curX][curY] = String.valueOf(i).charAt(0);
                        result = calculate(board, symbol, cur + 1);
                        //KEY POINT
                        if (result) {
                            break;
                        }
                        // unFill with ''
                        board[curX][curY] = '.';
                        fillData(symbol, curX, curY, i-1, '+');
                    }
                }
            } else {
                result = calculate(board, symbol, cur + 1);
            }
        }
        return result;
    }

    void fillData(char[][] symbol, int curX, int curY, int position, char item) {
        int firX = (curX / 3) * 3 + curY / 3 ;
        int secX = curX + 18;
        int thirdX = curY + 9;
        symbol[firX][position] = item;
        symbol[secX][position] = item;
        symbol[thirdX][position] = item;
    }

    boolean check(char[][] symbol, int curX, int curY, int position) {
        int firX = (curX / 3) * 3 + curY / 3 ;
        int secX = curX + 18;
        int thirdX = curY + 9;
        return symbol[firX][position] != '.' && symbol[secX][position] != '.' && symbol[thirdX][position] != '.';
    }

    void display(char[][] data) {
        for (int i = 0;i < data.length;i++) {
            System.out.println(new String(data[i]));
        }
    }

    public static void main(String[] args) {
        char[][] data = new char[][]{
            "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
};


        SudokuSolver sample = new SudokuSolver();
        sample.solveSudoku(data);
        sample.display(data);
    }

}
