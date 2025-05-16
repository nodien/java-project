import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interstRate = 1.0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        money = sc.nextDouble();

        System.out.println("Enter number of months: ");
        month = sc.nextInt();

        System.out.print("Enter annual investment rate percentage: ");
        interstRate = sc.nextDouble();

        double totalInterest = 0;
        for (int i = 1; i <= month; i++) {
            totalInterest += money * (interstRate/100)/12 * month;
        }

        System.out.println("Total interest: " + totalInterest);
    }
}
