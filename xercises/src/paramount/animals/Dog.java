package paramount.animals;

public class Dog extends Animal implements Miscellany.Course.OurComparable {
    public Dog(String name, int age) {
        super(name, age);
        this.noise = "Woof!";
    }

    @Override
    public int compareTo(Object o) {
        if (this.age < ((Dog) o).age) return -1;
        else if (this.age == ((Dog) o).age) return 0;
        else return 1;
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + makeNoise());
    }

    public void playFetch() {
        System.out.println("Fetch, " + name + "!");
    }
}
