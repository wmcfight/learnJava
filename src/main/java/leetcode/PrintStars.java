package leetcode;

/**
 * Created by wmc on 2015/2/9.
 */
public class PrintStars {
    public void reverse(LinkNode head) {
        if (head == null || head.next == null) return;
        LinkNode prev = head.next;
        LinkNode cur = prev.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = prev.next;
        }
    }

    public void display(LinkNode head) {
        LinkNode cur = head;
        while (cur != null) {
            System.out.printf(" " + cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        drawStar(100);
    }

    static void drawStar(int n) {
        if (n <= 0) return;
        long len = (n - 1) * 2 + 1, dep = len; //  len = 5, dep = 5
        long i = 1;
        while (i <= dep) {
            long curlen = i <= n  ? i : 2 * n - i; // curlen =
            long left = curlen + n -1;
            long right = n - curlen + 1;

            for (long j = 1; j <= len ; j++) {
                if (j >= right && j <= left) {
                    System.out.printf("*");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
            i++;
        }

    }




}



