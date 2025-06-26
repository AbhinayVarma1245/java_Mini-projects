@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaWithParameters {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a / b;

        System.out.println("Addition: " + add.operate(5, 3));
        System.out.println("Multiplication: " + multiply.operate(5, 3));
    }
}
