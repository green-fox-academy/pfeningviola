public class SubString {
    public static void main(String[] args) {
        String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};
        System.out.println(subStrList("ching", searchArr));
        System.out.println(subStrList("not", searchArr));
    }

    public static int subStrList(String searchedStr, String[] strList) {
        int index = 0;
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].contains(searchedStr)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }
}
