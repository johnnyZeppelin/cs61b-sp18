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

    public static void main(String[] args) {
        SLList<String> a = new SLList<String>();
        a.addFirst("asd");
        a.addFirst("asdfghjj");
        a.addFirst("asdfghjk");
        a.addFirst("asdfgh");
        System.out.println(longest(a));

        AList<String> b = new AList<String>();
        b.addFirst("asd");
        b.addFirst("asdfghjj");
        b.addFirst("asdfghjk");
        b.addFirst("asdfgh");
        System.out.println(longest(b));
    }
}
