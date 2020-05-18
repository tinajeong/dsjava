package migu.algorithm.study.tree;

public interface BinaryTree<T> {
    T makeBiTreeDataNode();
    T getLeftSubtree(T main);
    T getRightSubtree(T main);
    void makeLeftSubtree(T main, T sub);
    void makeRightSubtree(T main, T sub);

    void inOrderTraverse(T main);
    void preOrderTraverse(T main);
    void postOrderTraverse(T main);
}
