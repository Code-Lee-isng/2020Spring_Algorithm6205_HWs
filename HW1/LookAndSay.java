package hw1;

/**
 * File Name: LookAndSay.java
 * LookAndSay concrete class
 * <p>
 * <p>
 * To Compile: IntUtil.java RandomInt.java LookAndSay.java LookAndSayBase.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class LookAndSay extends LookAndSayBase {
    LookAndSay() {
        //NOTHING CAN BE CHANGED HERE
        testBench();
    }

    @Override
    protected String lookAndSay(String s) {
        //NOTHING CAN BE CHANGED HERE
        return alg(s);
    }

    @Override
    protected String lookAndSay(int n) {
        //NOTHING CAN BE CHANGED HERE
        return alg(n);
    }

    private String alg(String s) {
        //WRITE CODE
        //You can have any number of private functions and variables
        StringBuilder sb = new StringBuilder();
        //count, quantity of duplicate letters,
        int count = 1, i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                //duplicated letters increasing by 1,
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(s.charAt(i - 1));
        return sb.toString();
    }

    private String alg(int n) {
        //WRITE CODE
        //You can have any number of private functions and variables
        if (n <= 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        String te = alg(n - 1);
        return alg(te);
    }

    public static void main(String[] args) {
        //NOTHING CAN BE CHANGED HERE
        System.out.println("LookAndSay problem STARTS");
        LookAndSay m = new LookAndSay();
        System.out.println("All LookAndSay tests passed. You are genius");
        System.out.println("LookAndSay problem ENDS");
    }
}