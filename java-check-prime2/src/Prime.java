import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println("Not prime number");
            return;
        }

        int i = 2;
        boolean isPrime = true;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }
        if (isPrime) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not prime number");
        }

    }
}
