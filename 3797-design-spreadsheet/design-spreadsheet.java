import java.util.*;

class Spreadsheet {
    final int rows;
    final int[][] a;
    public Spreadsheet(int rows) {
        this.rows = rows;
        this.a = new int[26][rows];
    }
    public void setCell(String cell, int value) {
        int c = cell.charAt(0) - 'A';
        int r = Integer.parseInt(cell.substring(1)) - 1;
        a[c][r] = value;
    }
    public void resetCell(String cell) {
        int c = cell.charAt(0) - 'A';
        int r = Integer.parseInt(cell.substring(1)) - 1;
        a[c][r] = 0;
    }
    public int getValue(String formula) {
        int plus = formula.indexOf('+', 1);
        String x = formula.substring(1, plus), y = formula.substring(plus + 1);
        return val(x) + val(y);
    }
    private int val(String t) {
        char c = t.charAt(0);
        if (c >= '0' && c <= '9') return Integer.parseInt(t);
        int col = c - 'A';
        int row = Integer.parseInt(t.substring(1)) - 1;
        return a[col][row];
    }
}
