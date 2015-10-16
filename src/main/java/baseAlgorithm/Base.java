package baseAlgorithm;

/**
 * Created by mwei on 15-8-26.
 */
public class Base {




        public static void printGraph(int n){
            if(n<=0){
                return;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int x = 1; x <= 2 * i - 1; x++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = n-1; i>=1 ; i--) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int x = 1; x <= 2 * i - 1; x++) {
                    System.out.print("*");
                }
                System.out.println();
            }



        }

        public static void main(String[] args) {
            for(int i=1;i<5;i++){
                printGraph(i);

                System.out.println();
                System.out.println();
                System.out.println();
            }


        }
    }
