package company.amazon;

public class InterviewTask {
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean findString(char[][] data, String target) {
        if (target == null || data == null) return false;
        Character begin = target.charAt(0);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == begin) {
                    //search the node
                    if (searchNode(data, i, j, target)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private boolean searchNode(char[][] data, int curX, int curY, String target) {
        if (target.length() <= 1) return true; // as the target just like "a", "b"
        Character sec = target.charAt(1);
        // get the direction
        boolean findDir = false;
        for (int dirX = -1; dirX <=1 ;dirX++) {
            if (curX + dirX < 0 || curX + dirX >= data.length) continue;
            for (int dirY = -1; dirY <=1 ;dirY++) {
                if (curY + dirY < 0 || curY + dirY >= data[0].length) continue;
                if (dirX == 0 && dirY == 0) continue;
                if (data[curX + dirX][curY + dirY] == sec) {
                    int tempX = curX + dirX;
                    int tempY = curY + dirY;
                    findDir = true;
                    for (int k = 2; k < target.length(); k++) {
                        // this is the edge condition I missed!!!!
                        if (tempX + dirX < 0  || tempX + dirX >= data.length
                                || tempY + dirY < 0 || tempY + dirY >= data[0].length) {
                            findDir = false;
                            break;
                        }
                        if (data[tempX + dirX][tempY + dirY] != target.charAt(k)) {
                            // search not OK
                            findDir = false;
                            break;
                        }
                        tempX += dirX;
                        tempY += dirY;
                    }
                    if(findDir) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        char[][] data = {{'a', 'b', 'c'}, {'d', 'e', 'f'},{'g','h','i'}};
        InterviewTask sample = new InterviewTask();
        System.out.println(sample.findString(data, "abcd"));
        System.out.println(sample.findString(data, "efg"));
        System.out.println(sample.findString(data, "a"));
        System.out.println(sample.findString(data, "aa"));
    }
}
