/** This interface defines a method for determining equality of characters. */
public interface CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    boolean equalChars(char x, char y);
}

class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == 1 || y - x == 1;
    }
}

class OffByN implements CharacterComparator {
    private int _N;
    public OffByN(int N) {
        _N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == _N || y - x == _N;
    }
}
