package hw1;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println(pow(3, 11));
        System.out.println(powWithParity(3, 11));
        int[] numbers = new int[101];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        System.out.println(countRowSum(numbers));
    }

    public static int pow (int base, int pow) {
        int result = base;
        for(int i = 1; i < pow; i++) {
            result *= base;
        }
        return result;
    }

    public static int powWithParity(int base, int pow) {
        int acc = 1;
        while (pow != 1) {
            if (pow % 2 == 0) {
                base *= base;
                pow /= 2;
            } else {
                acc *= base;
                pow -= 1;
            }
        }
        return base * acc;
    }

    public static int countRowSum(int[] numbers) {
        int length = numbers.length;
        int halfLengthRounded = new Double(Math.floor(length * 1.0 / 2)).intValue();
        if (length % 2 == 0) {
            return (numbers[0] + numbers[length - 1]) * halfLengthRounded;
        } else {
            return (numbers[0] + numbers[length - 1]) * halfLengthRounded + numbers[halfLengthRounded];
        }
    }
}
