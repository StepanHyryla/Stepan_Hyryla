import java.util.Arrays;

public class ExtraTask1 {

    // Utility function to swap two digit
    static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // this function make char array[] from given number,
    // then finds the next greater number.
    // It modifies the same array to store the result
    int findNext(Integer number) {
        int i;
        char array[] = number.toString().toCharArray();
        int lenght = array.length;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = lenght - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0) {
            return -1;
        } else {
            int x = array[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < lenght; j++) {
                if (array[j] > x && array[j] < array[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(array, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(array, i, lenght);
        }
        return Integer.parseInt(String.valueOf(array));
    }
}
