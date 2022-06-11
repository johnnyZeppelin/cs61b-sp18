package ADT61B.Stack;

import org.junit.Test;

public class TestStack {
    @Test
    public void testExtensionStack() {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < 5; ++i) {
            integerStack.push(i + 1);
        }
        System.out.println(integerStack.popup());
        System.out.println(integerStack.popup());
        assert !integerStack.isEmpty();
        assert integerStack.popup().equals(3);
        integerStack.printList();
        assert integerStack.popup().equals(2);
        assert integerStack.size() == 1;
        integerStack.popup();
        assert integerStack.isEmpty();
    }
}
