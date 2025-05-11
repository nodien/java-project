import java.util.Scanner;

public class BodyMassIndex {
    public void somethingFunction(){
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;

        System.out.println("Enter the weight (in kilograms): ");
        weight = sc.nextDouble();
        System.out.println("Enter the height (in meters): ");
        height = sc.nextDouble();

        bmi = weight / height * height;
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18) {
            System.out.printf("%-20.2f%s", bmi, "Underweight\n");
        } else if (bmi < 25.0) {
            System.out.printf("%-20.2f%s", bmi, "Normal weight\n");
        } else if (bmi < 30.0) {
            System.out.printf("%-20.2f%s", bmi, "Overweight\n");
        } else {
            System.out.printf("%-20.2f%s", bmi, "Obese\n");
        }


    }
}
