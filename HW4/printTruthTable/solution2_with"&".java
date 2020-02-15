    private static void printTruthTable(int n) {
        long num = (long) 1 << n;
        for (int i = 0; i < num; i++) {
            printNum(i, n);
        }
    }

    private static void printNum(int i, int n) {
        //System.out.println("i = " + i);
        int k = n;
        for (int j = 0; j < n; j++) {
            int te = ((1 << (k-- - 1)) & i);
            //System.out.println("te = " + te);
            //System.out.println("j = " + j);
            char ch = te == 0 ? '0' : '1';
            System.out.print(ch);
        }
        System.out.println();
    }
