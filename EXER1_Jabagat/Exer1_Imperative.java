public class Exer1_Imperative {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total = total + numbers[i];
        }

        System.out.println("Sum is: " + total);
    }
}
