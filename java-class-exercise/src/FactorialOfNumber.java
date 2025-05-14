import java.util.Scanner;

public class FactorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = 0;

        if (n == 0) {
            System.out.println("1");
            return;
        }

        result = n;

        while(n > 1){
            n--;
            result *= n;
        }

        System.out.println(result);
    }
}
