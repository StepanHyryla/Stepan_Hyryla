import java.util.List;
import java.util.stream.IntStream;

class Task4 {

    // Using for
    public int getPairsCountUsingFor(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    // Using stream
    public int getPairsCountUsingStream(List<Integer> array, int target) {
        int count = IntStream.range(0, array.size()).map(i -> (int) IntStream.range(0, array.size())
                .filter(j -> i != j && array.get(i) + array.get(j) == target).count()).sum();
        return count / 2;
    }
}
