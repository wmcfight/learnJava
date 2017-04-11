package interview;

public class BookingCom {

    void StairCase(int n) {
        if (n <= 0) return;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++ ) {
                if ( i + j < n) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("#");
                }
            }
            System.out.println("");
        }

    }

    static int sum(int[] numbers) {
        if (numbers.length <= 1) return 0;
        double result = 0;
        for (int i = 1; i < numbers.length; i++) {
            result += numbers[i];
        }
        return (int) result;

    }



    public static void main(String[] args) {
        BookingCom bookingCom = new BookingCom();
        bookingCom.StairCase(3);
    }
}
