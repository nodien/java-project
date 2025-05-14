import java.util.Scanner;

public class MaxValueOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int max =0;
        while (num!=0) {
            int temp = num%10;
            max = Math.max(max,temp);
            num = num/10;
        }
        System.out.println(max);
    }
}
