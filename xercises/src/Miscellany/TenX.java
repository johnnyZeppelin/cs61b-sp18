package Miscellany;

public class TenX implements IntegerUnary {
    @Override
    public int tenX(int x) {
        return x * 10;
    }

    public static int doTwice(IntegerUnary f, int x) {
        return f.tenX(f.tenX(x));
    }

    public static void main(String[] args) {
        System.out.println(doTwice(new TenX(), 3));
    }
}
