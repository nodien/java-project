import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a euqation as 'a * x _ b = c', please enter constants: ");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a: ");
        double a = sc.nextDouble();

        System.out.println("Enter b: ");
        double b = sc.nextDouble();

        System.out.println("Enter c: ");
        double c = sc.nextDouble();

        if(a != 0){
            double result = (c-b)/a;
        } else {
            if(b == c){
                System.out.println("The equation is all x");
            } else {
                System.out.println("The equation have no solution");
            }
        }
    }
}
