import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class MultiStepCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> expressions = new ArrayList<>();
        ArrayList<Double> results = new ArrayList<>();
        int totalNumbers = 0;
        while (true) {
            System.out.print("How many numbers do you want to perform operations with? (Minimum 2): ");
            if (sc.hasNextInt()) {
                totalNumbers = sc.nextInt();
                if (totalNumbers >= 2) break;
                else System.out.println("Please enter a number 2 or greater.");
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
        sc.nextLine(); 
        System.out.println("Chain operations (+, -, *, /, (, ))");
        char cont = 'y';
        while (cont == 'y' || cont == 'Y') {
            StringBuilder expression = new StringBuilder();
            double firstNum = getDouble(sc, "Enter first number: ");
            expression.append(firstNum);
            int numbersCount = 1;
            boolean expectNumber = false;
            while (numbersCount < totalNumbers) {
                if (expectNumber) {
                    double nextNum = getDouble(sc, "Enter next number: ");
                    expression.append(nextNum);
                    numbersCount++;
                    expectNumber = false;
                } else {
                    System.out.print("Enter operator (+, -, *, /, (, )) or 'n' to finish early: ");
                    String op = sc.next();
                    if (op.equalsIgnoreCase("n")) break;

                    if (op.length() != 1 || "+-*/()".indexOf(op.charAt(0)) == -1) {
                        System.out.println("Invalid operator! Try again.");
                        continue;
                    }
                    char operator = op.charAt(0);
                    if (operator == '(' && expression.length() > 0) {
                        char lastChar = expression.charAt(expression.length() - 1);
                        if (Character.isDigit(lastChar) || lastChar == ')') {
                            expression.append(" * ");
                        }
                    }
                    expression.append(" ").append(operator).append(" ");
                    if (operator == '(') {
                        expectNumber = true;
                    } else if (operator == ')') {
                        expectNumber = false;
                    } else {
                        expectNumber = true;
                    }
                }
            }
            try {
                double result = evaluateExpression(expression.toString());
                System.out.println("Expression: " + expression);
                System.out.println("Final result: " + result);
                expressions.add(expression.toString());
                results.add(result);
                ArrayList<Double> oddNumbers = new ArrayList<>();
                ArrayList<Double> evenNumbers = new ArrayList<>();
                extractNumbers(expression.toString(), oddNumbers, evenNumbers);

                System.out.print("Odd numbers entered: ");
                printNumberList(oddNumbers);
                System.out.print("Even numbers entered: ");
                printNumberList(evenNumbers);
            } catch (Exception e) {
                System.out.println("Invalid expression: " + e.getMessage());
            }
            System.out.print("Start a new calculation? (y/n): ");
            String input = sc.next();
            cont = input.isEmpty() ? 'n' : input.toLowerCase().charAt(0);
            sc.nextLine();
            if (cont == 'y' || cont == 'Y') {
                while (true) {
                    System.out.print("How many numbers do you want to perform operations with? (Minimum 2): ");
                    if (sc.hasNextInt()) {
                        totalNumbers = sc.nextInt();
                        if (totalNumbers >= 2) break;
                        else System.out.println("Please enter a number 2 or greater.");
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        sc.next();
                    }
                }
                sc.nextLine();
            }
        }
        System.out.println("\n=== Summary of Calculations ===");
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println((i + 1) + ". " + expressions.get(i) + " = " + results.get(i));
        }
        System.out.println("Thanks for using the calculator!");
        sc.close();
    }
    static double getDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) return sc.nextDouble();
            else {
                System.out.println("Invalid input. Enter a valid number.");
                sc.next();
            }
        }
    }
    static void extractNumbers(String expr, ArrayList<Double> oddNumbers, ArrayList<Double> evenNumbers) {
        String[] tokens = expr.split("[^0-9.]+");
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    double num = Double.parseDouble(token);
                    int intPart = (int) num;
                    if (intPart % 2 == 0) evenNumbers.add(num);
                    else oddNumbers.add(num);
                } catch (NumberFormatException ignored) {}
            }
        }
    }
    static void printNumberList(ArrayList<Double> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            double num = numbers.get(i);
            System.out.print(num == (int) num ? (int) num : num);
            if (i != numbers.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
    static double evaluateExpression(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", "");
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    sb.append(expr.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                continue;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') applyOp(values, ops.pop());
                if (ops.isEmpty()) throw new Exception("Mismatched parentheses.");
                ops.pop(); 
            } else if ("+-*/".indexOf(c) != -1) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    applyOp(values, ops.pop());
                }
                ops.push(c);
            } else {
                throw new Exception("Invalid character: " + c);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            if (ops.peek() == '(' || ops.peek() == ')') throw new Exception("Mismatched parentheses.");
            applyOp(values, ops.pop());
        }
        if (values.size() != 1) throw new Exception("Invalid expression.");
        return values.pop();
    }
    static void applyOp(Stack<Double> values, char op) throws Exception {
        if (values.size() < 2) throw new Exception("Missing operands.");
        double b = values.pop();
        double a = values.pop();
        switch (op) {
            case '+': values.push(a + b); break;
            case '-': values.push(a - b); break;
            case '*': values.push(a * b); break;
            case '/':
                if (b == 0) throw new Exception("Division by zero.");
                values.push(a / b);
                break;
        }
    }
    static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }
}
