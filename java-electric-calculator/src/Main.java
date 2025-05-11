import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter electric usage :");
        double electricUsage = sc.nextDouble();
        double totalUsage = 0;
        if (electricUsage > 0 && electricUsage <= 50 ) {
            totalUsage = electricUsage*1800;
        } else if (electricUsage > 50 && electricUsage <= 100 ) {
            double firstFifty = electricUsage - 50;
            totalUsage = 50*1800+firstFifty*2300;
        } else if (electricUsage > 100) {
            double secondFifty = electricUsage - 100;
            totalUsage = 50*1800+50*2300+secondFifty*3000;

        }
        System.out.println("Money have to pay: " + totalUsage + " VND");
    }
}