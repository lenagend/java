package 알고리즘;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(minKeyboardPresses("12156")); // Output: 4
        System.out.println(minKeyboardPresses("321")); // Output: 6
        System.out.println(minKeyboardPresses("1234567")); // Output: 5
        System.out.println(minKeyboardPresses("100")); // Output: 4
    }

    public static int minKeyboardPresses(String number) {
        int presses = 0;
        int i = 0;

        while (i < number.length()) {
            char digit = number.charAt(i);

            if (digit == '0') {
                // 현재 숫자가 0인 경우, 1번 누르면 됩니다.
                presses += 1;
                i++;
            } else if (i < number.length() - 1 && digit == number.charAt(i + 1) - 1) {
                // 현재 숫자가 다음 숫자와 연속되는 경우, 숫자를 입력하려면 1번만 누르면 됩니다.
                presses += 1;
                i += 2;
            } else {
                // 그 외의 경우, 숫자를 입력하려면 2번 눌러야 합니다 (원래 숫자와 함께 눌리는 숫자).
                presses += 2;
                i++;
            }
        }

        return presses;
    }
}
