package com.example.helloworld;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        var obj = new HelloWorld();
        obj.validateUserInputForXXS();
    }

    /*
     * Example for: IDS01-J. Normalize strings before validating them
     * This is to prevent accepting untrusted input strings
     * ex: an application's strategy for avoiding cross-site scripting (XSS) vulnerabilities may include
     * forbidding <script> tags in inputs
     */
    public void validateUserInputForXXS() {
        String str1 = "";

        /* String 'strInput' may be user controllable :input string from a form
           \uFE64 is normalized to < and \uFE65 is normalized to > using the NFKC normalization form */
        String strInput = "\uFE64" + "script" + "\uFE65";

        /* Validate the input string, to check script tags: Check for angle brackets */
        Pattern pattern1 = Pattern.compile("[<>]");
        Matcher matcher = pattern1.matcher(strInput);
        if (matcher.find()) {
            // Found black listed tag
            throw new IllegalStateException();
        } else {
            // do the work
        }

        // Normalize the input string
        strInput = Normalizer.normalize(strInput, Normalizer.Form.NFKC);
    }

    /*
     * Example for: THI00-J. Do not invoke Thread.run() method
     */
    public void threadRunSample() {
        Foo foo10 = new Foo();
        new Thread(foo10).run();
    }

    /*
     * Example for: NUM09-J. Do not use floating-point variables as loop counters
     */
    public void printLoop() {
        for (float i = 0; i < 5.0f; i++) {
            System.out.println(i);
        }
    }

    /*
     * Example for: ERR04-J. Do not complete abruptly from a finally-block.
     * Never use return, break, continue, or throw statements within a finally-block.
     */
    public boolean isCapitalized() {
        try {
            throw new IllegalStateException();
        } finally {
            System.out.println("Calculation completed");
            return true;
        }
    }

    /*
     * Example for: ERR07-J. Do not throw RuntimeException, Exception, or Throwable
     */
    public boolean isCapitalized(String s) {
        if (s == null) {
            throw new RuntimeException("Null String");
        }
        if (s.equals("")) {
            return true;
        }
        String first = s.substring(0, 1);
        String rest = s.substring(1);
        return (first.equals(first.toUpperCase()) && rest.equals(rest.toLowerCase()));
    }

    /*
     * Example for: ERR08-J. Do not catch NullPointerException or any of its ancestors
     */
    public boolean isName(String s) {
        try {
            String names[] = s.split(" ");

            if (names.length != 2) {
                return false;
            }
            return (isCapitalized(names[0]) && isCapitalized(names[1]));
        } catch (NullPointerException e) {
            return false;
        }
    }

    /*
     * Example for: ERR08-J. Do not catch NullPointerException or any of its ancestors
     */
    public int divisionByZero() {
        try {
            int result = 10 / 0; // ArithmeticException will be thrown
            return result;
        } catch (Throwable e) {
            System.out.println("Exception caught" + e.getMessage());
        } finally {
            return 0;
        }
    }
}
