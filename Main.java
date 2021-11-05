import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // First task
        Task1 task1 = new Task1();
        System.out.println("First task:");
        System.out.println("Expected output:");
        System.out.println("[1, 2, 'a', 'b'] => [1, 2]");
        System.out.println("[1, 2, 'a', 'b', 0, 15] => [1, 2, 0, 15]");
        System.out.println("[1, 2, 'a', 'b', 'aasf', '1', '123', 231] => [1, 2, 231]");
        System.out.println("Output:");
        System.out.printf("[1, 2, 'a', 'b'] => %s\n", task1.getIntegersFromList(Arrays.asList(1, 2, "a", "b")));
        System.out.printf("[1, 2, 'a', 'b', 0, 15] => %s\n",
                task1.getIntegersFromList(Arrays.asList(1, 2, "a", "b", 0, 15)));
        System.out.printf("[1, 2, 'a', 'b', 'aasf', '1', '123', 231] => %s\n",
                task1.getIntegersFromList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)));

        // Second task
        Task2 task2 = new Task2();
        System.out.println("\n\nSecond task:");
        System.out.println("Expected output:");
        System.out.println("stress => t");
        System.out.println("sTreSS => T");
        System.out.println("abab => null");
        System.out.println("Output:");
        System.out.printf("stress => %s\n", task2.first_non_repeated_letter("stress"));
        System.out.printf("sTreSS => %s\n", task2.first_non_repeated_letter("sTreSS"));
        System.out.printf("abab => %s\n", task2.first_non_repeated_letter("abab"));

        // Third task
        Task3 task3 = new Task3();
        System.out.println("\n\nThird task:");
        System.out.println("Expected output:");
        System.out.println("16 => 1 + 6 => 7 \n942 => 9 + 4 + 2 => 15 => 1 + 5=> 6");
        System.out.println("132189 => 1 + 3 + 2 + 1 + 8 + 9 => 24 => 2 + 4 => 6");
        System.out.println("493193 => 4 + 9 + 3 + 1 + 9 + 3 => 29 => 2 + 9 => 11 => 1 + 1 => 2");
        System.out.println("Answer:");
        System.out.printf("16 => %d\n", task3.getDigitalRoot(16));
        System.out.printf("942 => %d\n", task3.getDigitalRoot(942));
        System.out.printf("132189 => %d\n", task3.getDigitalRoot(132189));
        System.out.printf("493193 => %d\n", task3.getDigitalRoot(493193));

        // Fourth task
        Task4 task4 = new Task4();
        int[] array = { 1, 3, 6, 2, 2, 0, 4, 5 };
        int target = 5;
        System.out.println("\n\nFour task:");
        System.out.println("Examles:");
        System.out.println("Given array of numbers [1, 3, 6, 2, 2, 0, 4, 5], with a target number = 5.");
        System.out.println("Expected output:");
        System.out.println("[1,4],[3,2],[3,2],[0,5] => 4");
        System.out.println("Answer:");
        System.out.printf("Using for: [1,4],[3,2],[3,2],[0,5] => %d\n", task4.getPairsCountUsingFor(array, target));
        System.out.printf("Using stream: [1,4],[3,2],[3,2],[0,5] => %d\n",
                task4.getPairsCountUsingStream(Arrays.asList(1, 3, 6, 2, 2, 0, 4, 5), target));

        // Fifth task
        Task5 five = new Task5();
        System.out.println("\n\nFifth task:");
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println("Input:");
        System.out.println(
                "(Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill)");
        System.out.println("Expected output:");
        System.out.println(
                "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)");
        System.out.println("Output:");
        System.out.println(five.meeting(s));

        // First extra task
        ExtraTask1 first = new ExtraTask1();
        System.out.println("\n\nFirst extra task:");
        System.out.println("Expected output:");
        System.out.println("513 => 531 \n2017 => 2071 \n111 => -1 \n531 => -1");
        System.out.println("Output:");
        System.out.printf("513 => %d\n", first.findNext(513));
        System.out.printf("2017 => %d\n", first.findNext(2017));
        System.out.printf("111 => %d\n", first.findNext(111));
        System.out.printf("531 => %d\n", first.findNext(531));

        // Second extra task
        ExtraTask2 second = new ExtraTask2();
        System.out.println("\n\nSecond extra task:");
        System.out.println("Expected output:");
        System.out.println("2149583361 => 128.32.10.1 \n32 => 0.0.0.32 \n0 => 0.0.0.0");
        System.out.println("Output:");
        System.out.printf("2149583361 => %s\n", second.longToIP(2149583361L));
        System.out.printf("32 => %s\n", second.longToIP(32));
        System.out.printf("0 => %s\n", second.longToIP(0));
    }
}
