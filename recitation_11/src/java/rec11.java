// Question 1

class Solver {
    public int fib(int n) {
        if (n <= 2) return 1;
        int a = 1, b = 1 , c = 0;
        for (int i = 3; i <= n; i ++) {
            c = b + a;
            a = b;
            b = c;
        }
        return b;
    }
    //  32 bit integer
    // largest value: 2^32 - 1 ; (0 1111...1111)_2 = 2147483647
    // BigInteger

    // cc(amount, d) = cc(amount - denomination(d), d) + cc(amount, d-1)
    private int[] denomination = {1, 5, 10, 20, 50};
    public int cc(int amount, int d) {
        if (amount == 0) return 1;
        if (amount < 0 || d == 0) return 0;
        return cc(amount - denomination[d-1], d) + cc(amount, d-1);
    }

    private int[][] dp = new int[105][6];
    // dp[amount][d] =  dp[amount - denomination[d-1]][d] + dp[amount][d-1]
    public int dp_cc(int amount) {
        for (int d = 0; d <= 5; d++) dp[0][d] = 1;
        for (int d = 1; d <= 5; d++)
            for (int i = 1; i <= amount; i++) {
                if (i - denomination[d-1] >= 0)
                    dp[i][d] = dp[i - denomination[d-1]][d] + dp[i][d-1];
                else
                    dp[i][d] = dp[i][d-1];
            }
        for (int i = 0; i <= amount; i++) {
            for (int d = 0; d<= 5; d++)
                System.out.print(dp[i][d] + " ");
            System.out.print("\n");
        }
        return dp[amount][5];
    }

    private int[] dp2 = new int[105];
    // dp[amount] =  dp[amount - denomination[d-1]] + dp[amount]
    // dp[amount] += dp[amount - denomination[d-1]]
    public int dp_cc2(int amount) {
        for (int i = 0; i <= amount; i++) dp2[i] = 0;
        dp2[0] = 1;
        for (int d = 0; d <= 5; d++)
            System.out.print(denomination[d - 1] + ": ");
            for (int i = 1; i <= amount; i++) {
                if (i - denomination[d - 1] >= 0)
                    dp2[i] += dp2[i - denomination[d - 1]];
                System.out.print(dp2[i] + " ");
            }
            System.out.print("\n");
        }
}

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        // for (int i =1; i <= 47; i++)
        //     System.out.println(i + ": " + solver.fib(i));
        System.out.println(solver.cc(11, 5));
        // 10 * 1 + 1 * 1
        // 5 * 2 + 1 * 1
        // 5 * 1 + 1 * 6
        // 1 * 11
        System.out.println(solver.dp_cc2(11));
    }
}

// Question 3
    private int[] dp2 = new int[105];
        // dp[amount] =  dp[amount - denomination[d-1]] + dp[amount]
        // dp[amount] += dp[amount - denomination[d-1]]
        public int dp_cc2(int amount) {
            for (int i = 0; i <= amount; i++) dp2[i] = 0;
            dp2[0] = 1;
            for (int d = 1; d <= 5; d++)
                System.out.print(denomination[d - 1] + ": ");
            for (int i = 1; i <= amount; i++) {
                if (i - denomination[d - 1] >= 0)
                    dp2[i] += dp2[i - denomination[d - 1]];
                System.out.print(dp2[i] + " ");
            }
            System.out.print("\n");
        }
        return dp2[amount];
    }

    public split()
}

    public List<List<Integer>> split(List<Integer> lst, int n) {
        List<Integer> le = new ArrayList<>();
        List<Integer> gt = new ArrayList<>();

        for (int i = 0; i < lst.size(); int ++){
            if (lst.get(i) > n) gt.add(lst.get(i));
            else le.add(lst.get(i));
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(le);
        result.add[gt];
        return result;
    }

    private Random rn = new Random();
    public List<Integer> quick_sort(List<Integer> lst) {
        if (lst.size() <= 1) return lst;

        int idx = rn.nextInt(lst.size()); // 0 ~ lst.size() - 1
        int n = lst.get(idx);

        List<List<Integer>> spl = split(lst, n);
        List<Integer> sorted_le = quick_sort(spl.get(0));
        List<Integer> sorted_gt = quick_sort(spl.get(1));

        sorted_le.addAll(sorted_gt); // similar to extend in python
        return sorted_le;
    }
}