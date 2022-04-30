import org.junit.Test;

public class TestAnimal {
    @Test
    public void testGreet() {
        Animal kitty = new Cat("Kitten", 12);
        kitty.greet();
    }
}
