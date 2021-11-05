import java.util.*;

public class Task5 {
    public String meeting(String s) {

        TreeMap<String, List<String>> people = new TreeMap<String, List<String>>();
        String[] persons = s.split(";");
        for (String person : persons) {
            String[] fullNames = person.split(":");
            String firstName = fullNames[1].toUpperCase();
            String secondName = fullNames[0].toUpperCase();

            if (!people.keySet().contains(firstName)) {
                List<String> names = new ArrayList<>();
                names.add(secondName);
                people.put(firstName, names);
            } else if (people.keySet().contains(firstName)) {
                List<String> names = people.get(firstName);
                names.add(secondName);
                Collections.sort(names);
                people.put(firstName, names);
            }
        }

        StringBuilder result = new StringBuilder();
        Set<String> secondNames = people.keySet();

        for (String secondName : secondNames) {
            List<String> names = people.get(secondName);
            for (String name : names) {
                result.append("(").append(secondName.toUpperCase()).append(", ").append(name.toUpperCase()).append(")");
            }
        }
        return result.toString();
    }
}
