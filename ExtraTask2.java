public class ExtraTask2 {
    public String longToIP(long ip) {
        // 1. translate the ip to binary representation
        String str = "";
        if (ip == 0) {
            str = ip + "";
        } else {
            while (ip != 0) {
                str = ip % 2 + str;
                ip = ip / 2;
            }
        }

        // 2. if the binary string short than 32 bit, then add "0" in front
        while (str.length() != 32) {
            str = "0" + str;
        }

        String result = "";
        // 3. truncate the str to four items
        for (int i = 0; i < 4; i++) {
            String partStr = str.substring(i * 8, 8 * (i + 1));
            // 4. translate every item to decimal number
            int bi = Integer.parseInt(partStr, 2);
            if (i == 3) {
                result += bi + "";
            } else {
                result += bi + ".";
            }
        }
        return result;
    }
}
