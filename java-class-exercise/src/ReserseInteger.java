import java.util.Scanner;

public class ReserseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int reserse = 0;
        sc.close();
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            reserse = reserse*10 + digit;
        }

        System.out.println(reserse);
    }
}
