import org.junit.Test;

public class TestAnimal {
    @Test
    public void testGreet() {
        Animal kitty = new Cat("Kitten", 12);
        kitty.greet();
    }

    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet();
        c.greet();
        d.greet();
        a = c;
        ((Cat) a).greet();
        a.greet();

        a = new Dog("Spot", 10);
        d = (Dog) a;
        a.greet();
        d.greet();

        paramount.B bbc = (paramount.B) new paramount.C();
        bbc.update();
        bbc.m2();
        System.out.println(bbc.x + ((paramount.C) bbc).y);
    }
}
