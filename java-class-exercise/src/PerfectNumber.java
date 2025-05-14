import java.util.Scanner;
import java.util.Vector;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        if (num < 2) {
            System.out.println("Not a perfect number");
        } else {
            int sum = 1;
            int sqrt = (int) Math.sqrt(num);

            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    sum += i;
                    int other = num / i;
                    if (other != i) {
                        sum += other;
                    }
                }
            }
            
            System.out.println("Is "+ num+" perfect number?: " + (sum == num));
        }
    }
}
