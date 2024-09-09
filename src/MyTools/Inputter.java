package MyTools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

    public static final Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again");
            return inputInt();
        }
    }

    public static double inputDouble() {
        try {
            return Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again");
            return inputDouble();
        }
    }

    public static int inputIntRange(int min, int max) {
        try {
            final int n = inputInt();
            if (n >= min && n <= max) {
                return n;
            } else {
                throw new NumberOutOfRangeException();
            }
        } catch (NumberOutOfRangeException e) {
            System.out.println("Number is out of range, try again");
            return inputIntRange(min, max);
        }
    }

    public static int inputIntMin(int min) {
        try {
            final int n = inputInt();
            if (n >= min) {
                return n;
            } else {
                throw new NumberOutOfRangeException();
            }
        } catch (NumberOutOfRangeException e) {
            System.out.println("Number out of range, try again");
            return inputIntMin(min);
        }
    }

    public static double inputDoubleMin(double min) {
        try {
            final double n = inputDouble();
            if (n >= min) {
                return n;
            } else {
                throw new NumberOutOfRangeException();
            }
        } catch (NumberOutOfRangeException e) {
            System.out.println("Number out of range, try again");
            return inputDoubleMin(min);
        }
    }

    public static String inputString() {
        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid string, try again");
            return inputString();
        }
    }

    public static String inputNonEmptyString() {
        try {
            String str = inputString();
            if (str.isEmpty()) {
                throw new EmptyStringException();
            }
            return str;
        } catch (EmptyStringException e) {
            System.out.println("String is empty, try again");
            return inputNonEmptyString();
        }
    }

    public static boolean inputBoolean() {
        String input = inputNonEmptyString();
        if (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")
            && !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
            System.out.println("Please enter true/false or yes/no");
            return inputBoolean();
        } else {
            return input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("true");
        }
    }
    
    public static boolean readBoolean(String prompt){
        System.out.println(prompt + ": ");
        return inputBoolean();
    }
    
    public static String normalizeDateStr(String dateStr){
        String result = dateStr.replaceAll("[\\s+]", "");
        result = result.replaceAll("[./-_]+", "-");
        return result;
    }
    
    public static String dateToString(Date date, String dateFormat){
        if(date == null) return "";
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
    
}

class NumberOutOfRangeException extends Exception {

    public NumberOutOfRangeException() {
    }
}

class EmptyStringException extends Exception {

    public EmptyStringException() {
    }
}
