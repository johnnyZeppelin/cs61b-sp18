package ADT61B.Tree;

public class TestTree {
    public static void main(String[] args) {
        Tree61B<Integer> tree61B = new BST<>(new Entry<>(5));
        //System.out.println(tree61B.size());
        for (int i = 0; i < 10; ++i) {
            tree61B.add(i);
        }
        ((BST) tree61B).printTree();
    }
}
