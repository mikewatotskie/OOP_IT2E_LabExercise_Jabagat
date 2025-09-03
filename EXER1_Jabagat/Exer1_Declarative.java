public class Exer1_Declarative {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8};
        int total = sum(numbers);  // Just say: "sum these numbers"

        System.out.println("Sum is: " + total);
    }

    public static int sum(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }
}
