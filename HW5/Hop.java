package hw5_part1;

/**
 * File Name: Hop.java
 * Hop concrete class
 * <p>
 * <p>
 * To Compile: IntUtil.java RandomInt.java Hop.java HopBase.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Hop extends HopBase {
    //You cannot have any functions or data here
    Hop() {
        //NOTHING CAN BE CHANGED HERE
        testBed();
    }

    int hopSmart(int[] s, int x) {
        //NOTHING CAN BE CHANGED HERE
        return alg(s, x);
    }

    /*
     *  WRITE CODE IN alg
     *  YOU CANNOT USE ANY static variable in this function
     *  YOU can use many local variables inside the function
     *  Cannot use any loop statements like:  for, while, do, while, go to
     *  Can use if
     *  ONLY AFTER THE execution of this routine array s MUST have the same contents as you got it.
     *  YOU cannot call any subroutine inside this function except alg itself
     *
     */

    private int alg(int[] s, int x) {
        //WRITE CODE
        //If your code is more than 10 lines, you don't understand the problem
        if(s[x] == x)
            return 0;

        int te = s[x];

        s[x] = s[s[x]];

        int res = 1 + alg(s, x);

        s[x] = te;

        return res;
    }

    //second way, turn it into negative numbers
    /*private int alg(int[] s, int x) {
        //WRITE CODE
        //If your code is more than 10 lines, you don't understand the problem
        int target, index, num = 65535;
        //get target & index
        if (x >= 0) {
            target = index = x;
        } else {
            index = x & num;
            target = ((x >> 16) * -1) - 1;
        }

        if (s[index] == target) {//find target
            return 0;
        } else {//if doesn't, get to next
            return 1 + alg(s, (((target + 1) * -1) << 16) | s[index]);
        }
    }
*/

    public static void main(String[] args) {
        //NOTHING CAN BE CHANGED HERE
        System.out.println("Hop problem STARTS");
        Hop m = new Hop();
        System.out.println("All Hop tests passed. You are great");
        System.out.println("Hop problem ENDS");
    }
}