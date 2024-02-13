public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] sen = text.split(",|:");
        int result = 0;

        for (String s : sen) {
            result += Integer.parseInt(s);
        }

        return result;
    }


}
