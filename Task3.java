public class Task3 {
    public int getDigitalRoot(int n) {
        int sum;
        String s = String.valueOf(n);
        do {
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int a = Character.getNumericValue(s.charAt(i));
                sum += a;
            }
            s = String.valueOf(sum);
        } while (sum > 9);
        return sum;
    }
}
