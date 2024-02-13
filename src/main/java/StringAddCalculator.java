import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        isValidText(text);
        isSatisfiedCustom(text);
        String[] sen = splitText(text);

        return sumString(sen);
    }

    private static int isValidText(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return 1;
    }

    private static String[] splitText(String text) {
        String[] sen = text.split(",|:");

        return sen;
    }

    private static int sumString(String[] str) {
        int result = 0;
        for (String s : str) {
            throwExceptionIfIsNotDigitSatisfied(s);
            int num = Integer.parseInt(s);
            throwExceptionIfMinusSatisfied(num);
            result += num;
        }
        return result;
    }

    private static void throwExceptionIfIsNotDigitSatisfied(String str) {
        char c = str.charAt(0);

        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }

    }

    private static void throwExceptionIfMinusSatisfied(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int isSatisfiedCustom(String text) {
        int result = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for(String token : tokens){
                result += Integer.parseInt(token);
            }
        }
        return result;
    }


}
