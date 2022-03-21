package Numbers;

public class RomanToInt {
    public int[] compute(char c1, char c2) {
        int[] res = new int[2];
        switch (c1) {
            case 'I':
                if (c2 == 'V') {
                    res[0] = 4;
                    res[1] = 2;
                } else if (c2 == 'X') {
                    res[0] = 9;
                    res[1] = 2;
                } else {
                    res[0] = 1;
                    res[1] = 1;
                }
                break;
            case 'V':
                res[0] = 5;
                res[1] = 1;
                break;
            case 'X':
                if (c2 == 'L') {
                    res[0] = 40;
                    res[1] = 2;
                } else if (c2 == 'C') {
                    res[0] = 90;
                    res[1] = 2;
                } else {
                    res[0] = 10;
                    res[1] = 1;
                }
                break;
            case 'L':
                res[0] = 50;
                res[1] = 1;
                break;
            case 'C':
                if (c2 == 'D') {
                    res[0] = 400;
                    res[1] = 2;
                } else if (c2 == 'M') {
                    res[0] = 900;
                    res[1] = 2;
                } else {
                    res[0] = 100;
                    res[1] = 1;
                }
                break;
            case 'D':
                res[0] = 500;
                res[1] = 1;
                break;
            case 'M':
                res[0] = 1000;
                res[1] = 1;
                break;
            default:
                break;
        }
        return res;
    }

    public int romanToInt(String s) {
        if (s == null || s.length() < 1) return 0;
        int res = 0, len = s.length();
        int[] temp;
        char c1, c2;
        for (int i = 0; i < len; ) {
            c1 = s.charAt(i);
            if (i + 1 < len) {
                c2 = s.charAt(i + 1);
            } else {
                c2 = '.';
            }
            temp = compute(c1, c2);
            res += temp[0];
            i += temp[1];
        }
        return res;
    }
}
