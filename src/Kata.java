public class Kata {

    public static char triangle(final String row) {
        if (row.length() < 2) {
            return row.charAt(0);
        }
        StringBuilder sb = new StringBuilder(row);
        while (sb.length() > 2) {
            for (int i = 1; i < sb.length(); i++) {
                char first = sb.charAt(i - 1);
                sb.setCharAt(i - 1, getColor(first, sb.charAt(i)));
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return getColor(sb.charAt(0), sb.charAt(1));
    }

    private static char getColor(final char a, final char b) {
        if (a == 'B' && b == 'G' || b == 'B' && a == 'G') {
            return 'R';
        } else if (a == 'R' && b == 'G' || b == 'R' && a == 'G') {
            return 'B';
        } else if (a == 'B' && b == 'R' || b == 'B' && a == 'R') {
            return 'G';
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Kata.triangle("RGBG"));
    }
}