public class Main {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;

        System.out.println("Suma: " + add.calculate(5, 3));
        System.out.println("Resta: " + subtract.calculate(5, 3));
        System.out.println("Multiplicación: " + multiply.calculate(5, 3));
        System.out.println("División: " + divide.calculate(5, 3));
    }
}
