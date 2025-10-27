class Bank {
    private final long[] bal;
    private final int n;

    public Bank(long[] balance) {
        this.bal = balance;
        this.n = balance.length;
    }

    private boolean valid(int acc) {
        return acc >= 1 && acc <= n;
    }

    public boolean transfer(int a1, int a2, long m) {
        if (!valid(a1) || !valid(a2) || bal[a1 - 1] < m) return false;
        bal[a1 - 1] -= m;
        bal[a2 - 1] += m;
        return true;
    }

    public boolean deposit(int a, long m) {
        if (!valid(a)) return false;
        bal[a - 1] += m;
        return true;
    }

    public boolean withdraw(int a, long m) {
        if (!valid(a) || bal[a - 1] < m) return false;
        bal[a - 1] -= m;
        return true;
    }
}
