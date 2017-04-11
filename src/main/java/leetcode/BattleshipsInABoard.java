package leetcode;

/*
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

 */
/**
 * 该题比较简单，因为给的board 没有错误
 * 如果有错误，错误为0，比较难做
 *
 * 升级版：
 * 采用check and fill
 * 注意需要记录状态，如果同时横竖都有，则不合规，遍搽遍记录状态，不能最后搽，容易进入死循环
 */
public class BattleshipsInABoard {
    private static volatile boolean global = false;
    private static volatile boolean existX = false;
    private static volatile boolean existY = false;

    public int countBattleships(char[][] board) {
        if (board == null || board.length <= 0 || board[0].length <=0 ) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j)) {
                    global = true;
                    existX = false;
                    existY = false;
                    fill(board, i, j);
                    if (global) {
                        result++;
                    }
                }

            }
        }
        return result;
    }

    public boolean checkAndFill(char[][] board, int curX, int curY) {
        if (curX  >= board.length
                || curY >= board[0].length) {
            return true;
        }

        if (board[curX][curY] != '.') {
            checkAndFill(board, curX + 1, curY);
            checkAndFill(board, curX, curY + 1);
            board[curX][curY] = '.';
        } else {
            return false;
        }

        return true;
    }

    public boolean check(char[][]board, int curX, int curY) {
        if (curX  >= board.length
                || curY >= board[0].length
                || curX < 0
                || curY < 0) {
            return false;
        }
        return board[curX][curY] != '.';
    }

    public void fill(char[][] board, int curX, int curY) {
        if (curX  >= board.length
                || curY >= board[0].length
                || curX < 0
                || curY < 0) {
            return;
        }

        if (board[curX][curY] != '.') {
            board[curX][curY] = '.';
            existX = check(board, curX + 1, curY)
                    || check(board, curX - 1, curY) || existX;
            existY = check(board, curX, curY + 1)
                    || check(board, curX, curY - 1) || existY;
            if (existX && existY) {
                global = false;
            }

            if (existX) {
                fill(board, curX + 1, curY);
                fill(board, curX - 1, curY);
            }
            if (existY) {
                fill(board, curX , curY + 1);
                fill(board, curX , curY - 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{"...X".toCharArray(),
                "XXXX".toCharArray(),
                "X..X".toCharArray()
                                        };

        BattleshipsInABoard battleshipsInABoard = new BattleshipsInABoard();
        int data = battleshipsInABoard.countBattleships(board);
        System.out.println("result" + data);

    }
}
