package com.example.helloworld;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
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
