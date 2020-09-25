import java.util.Scanner;

public class findIndexOfKMinAlg {
    public static int findIndexOfKMin(int[] numbers, int k) {
        // write your code here
        if (numbers.length < 1 || k > numbers.length) {
            return -1;
        }
        int index = 0;
        int counter = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[index]) {
                counter = 1;
                index = i;
            } else if (numbers[i] == numbers[index] && counter++ < k) {
                index = i;
            }
        }
        return counter < k ? -1 : index;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int k = 4;
        final int[] numbers = {18, 4, 17, 4, 19, 18, 4};
        /*if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            k = Integer.parseInt(scanner.nextLine());
        } else {
            numbers = new int[0];
            k = 1;
        }*/
        System.out.println(findIndexOfKMin(numbers, k));
    }
}
