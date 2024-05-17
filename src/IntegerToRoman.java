public class IntegerToRoman {
    private static final int[] MILESTONES = {10000, 9000, 5000, 4000, 1000,
            900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] MILESTONESPAIRS = {"X̅", "I̅X̅", "V̅", "MV̅", "M",
            "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        int temp;
        StringBuilder builder = new StringBuilder();

        if (num < 1 || num > 10000) {
            return null;
        }

        while (num > 0) {
            for (int i = 0; i < MILESTONES.length; i++) {
                temp = num - MILESTONES[i];
                if (temp >= 0) {
                    builder.append(MILESTONESPAIRS[i]);
                    num = num - MILESTONES[i];
                    i--;
                }
            }
        }
        return builder.toString();
    }
}


