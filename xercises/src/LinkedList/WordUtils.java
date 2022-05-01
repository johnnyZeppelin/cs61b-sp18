package LinkedList;
public class WordUtils {
    public static String longest(SLList<String> stringSLList) {
        SLList<String> p = new SLList(stringSLList);
        String res = "";
        while (!p.isEmpty()) {
            String temp = p.removeFirst();
            if (res.length() < temp.length()) res = temp;
        }

        return res;
    }

    public static String longest(AList<String> stringAList) {
        String res = "";
        for (int i = 0; i < stringAList.size(); ++i) {
            String temp = stringAList.get(i);
            if (res.length() < temp.length()) res = temp;
        }

        return res;
    }
}
