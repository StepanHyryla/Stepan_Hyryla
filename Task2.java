public class Task2 {

    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    static void getCharCountArray(String word) {
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i)]++;
        }
    }

    public Character first_non_repeated_letter(String word) {
        getCharCountArray(word);
        for (int i = 0; i < word.length(); i++) {
            if (count[word.charAt(i)] == 1) {
                return word.charAt(i);
            }
        }
        return null;
    }
}
