package 알고리즘;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] usa = {"AB", "AA", "TTTT"};
        String[] incs = {"AB BCD AA AAA TTTT AAAAA", "BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};
        System.out.println(maxTogetherRisingDays(kor, usa, incs)); // Output: 3
    }

    public static int maxTogetherRisingDays(String[] kor, String[] usa, String[] incs) {
        int maxDays = 0;
        Map<String, Integer> risingCounter = new HashMap<>();

        for (String incDay : incs) {
            String[] incList = incDay.split(" ");

            for (String korStock : kor) {
                if (!Arrays.asList(incList).contains(korStock)) {
                    continue;
                }

                for (String usaStock : usa) {
                    if (!Arrays.asList(incList).contains(usaStock)) {
                        continue;
                    }

                    String pair = korStock + "," + usaStock;
                    risingCounter.put(pair, risingCounter.getOrDefault(pair, 0) + 1);
                    maxDays = Math.max(maxDays, risingCounter.get(pair));
                }
            }
        }

        return maxDays;
    }
}
