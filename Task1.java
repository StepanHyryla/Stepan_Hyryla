import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public List<Integer> getIntegersFromList(List<Object> listOfItems) {
        List<Integer> nums = new ArrayList<Integer>();
        for (Integer i = 0; i < listOfItems.size(); i++) {
            if (listOfItems.get(i) instanceof Integer) {
                nums.add((Integer) listOfItems.get(i));
            }
        }

        return nums;
    }
}
