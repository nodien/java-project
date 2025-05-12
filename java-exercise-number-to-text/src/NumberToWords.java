public class NumberToWords {
    private static final String[] BELOW_TWENTY = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num).trim();
    }

    private String helper(int num) {
        String result = "";

        if (num < 20) {
            result = BELOW_TWENTY[num];
        } else if (num < 100) {
            result = TENS[num / 10] + " " + helper(num % 10);
        } else if (num < 1_000) {
            result = helper(num / 100) + " Hundred " + helper(num % 100);
        } else if (num < 1_000_000) {
            result = helper(num / 1_000) + " Thousand " + helper(num % 1_000);
        } else if (num < 1_000_000_000) {
            result = helper(num / 1_000_000) + " Million " + helper(num % 1_000_000);
        } else {
            result = helper(num / 1_000_000_000) + " Billion " + helper(num % 1_000_000_000);
        }

        return result.trim();
    }

    public static void main(String[] args) {
        NumberToWords converter = new NumberToWords();
        int[] tests = {0, 5, 13, 85, 523, 12345, 1000010, 2147483647};

        for (int num : tests) {
            System.out.printf("%d -> \"%s\"%n", num, converter.numberToWords(num));
        }
    }
}
