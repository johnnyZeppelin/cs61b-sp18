package paramount;

public class A {
    protected void m00() {
        System.out.println("HAha");
    }

    public int x = 5;
    private int xx = 6;
    protected int xxx = 7;

    public void m1() {
        System.out.println("Am1-> " + xxx);
    }

    public void m2() {
        System.out.println("Am2-> " + this.x);
    }

    public void update() {
        x = 99;
    }

    public void jusam() {
        System.out.println("Conggulongyimida");
    }
}
