package migu.algorithm.study.tree;

import migu.algorithm.study.data.BiTreeIntDataNode;
import migu.algorithm.study.data.IntData;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class BinaryTreeIntDataImpl implements BinaryTree<BiTreeIntDataNode> {

    @Override
    public BiTreeIntDataNode makeBiTreeDataNode() {
        return new BiTreeIntDataNode();
    }

    @Override
    public BiTreeIntDataNode getLeftSubtree(BiTreeIntDataNode main) {
        return (BiTreeIntDataNode) main.getLeft();
    }

    @Override
    public BiTreeIntDataNode getRightSubtree(BiTreeIntDataNode main) {
        return (BiTreeIntDataNode) main.getRight();
    }

    @Override
    public void makeLeftSubtree(BiTreeIntDataNode main, BiTreeIntDataNode sub) {
        if (main.getLeft() != null)
            main.setLeft(null);
        main.setLeft(sub);
    }

    @Override
    public void makeRightSubtree(BiTreeIntDataNode main, BiTreeIntDataNode sub) {
        if (main.getRight() != null)
            main.setRight(null);
        main.setRight(sub);
    }

    public IntData getData(BiTreeIntDataNode BiTreeIntDataNode) {
        return BiTreeIntDataNode.getData();
    }

    public void setData(BiTreeIntDataNode biTreeIntDataNode, IntData data) {
        biTreeIntDataNode.setData(data);
    }

    @Override
    public void inOrderTraverse(BiTreeIntDataNode main) {
        if (main == null)
            return;

        inOrderTraverse((BiTreeIntDataNode) main.getLeft());
        System.out.println(main.getData().getData());
        inOrderTraverse((BiTreeIntDataNode) main.getRight());
    }

    @Override
    public void preOrderTraverse(BiTreeIntDataNode main) {
        if (main == null)
            return;

        System.out.println(main.getData().getData());
        preOrderTraverse((BiTreeIntDataNode) main.getLeft());
        preOrderTraverse((BiTreeIntDataNode) main.getRight());
    }

    @Override
    public void postOrderTraverse(BiTreeIntDataNode main) {
        if (main == null)
            return;

        postOrderTraverse((BiTreeIntDataNode) main.getLeft());
        postOrderTraverse((BiTreeIntDataNode) main.getRight());
        System.out.println(main.getData().getData());
    }

    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        Runtime.getRuntime().gc();
        System.out.println("Sleeping");
        Thread.sleep(5000);
    }

    // this code doesn't free any actual memory. : call-by-value
    public static void deleteTree(BiTreeIntDataNode main) {
        if (main == null)
            return;
        deleteTree((BiTreeIntDataNode) main.getLeft());
        deleteTree((BiTreeIntDataNode) main.getRight());
        main = null;
    }

    // deleteTree method doesn't free actual memory, but we can change strong reference to weak reference.
    // after the collect method is called, the object may be collected.
    public static void main(String[] args) throws InterruptedException {
        BinaryTreeIntDataImpl binaryTree = new BinaryTreeIntDataImpl();
        ReferenceQueue<BiTreeIntDataNode> referenceQueue = new ReferenceQueue<>();
        WeakReference<BiTreeIntDataNode> weak = new WeakReference<>(binaryTree.makeBiTreeDataNode(),referenceQueue);
        BiTreeIntDataNode root = weak.get();
        root.setData(new IntData(1));

        WeakReference<BiTreeIntDataNode> weakBt1 = new WeakReference<>(binaryTree.makeBiTreeDataNode(),referenceQueue);
        BiTreeIntDataNode bt1 = weakBt1.get();
        bt1.setData(new IntData(2));
        WeakReference<BiTreeIntDataNode> weakBt2 = new WeakReference<>(binaryTree.makeBiTreeDataNode(),referenceQueue);
        BiTreeIntDataNode bt2 = weakBt2.get();
        bt2.setData(new IntData(3));
        WeakReference<BiTreeIntDataNode> weakBt3 = new WeakReference<>(binaryTree.makeBiTreeDataNode(),referenceQueue);
        BiTreeIntDataNode bt3 = weakBt3.get();
        bt3.setData(new IntData(4));

        binaryTree.makeLeftSubtree(root, bt1);
        binaryTree.makeRightSubtree(root, bt2);
        binaryTree.makeLeftSubtree(bt1, bt3);

        System.out.println(binaryTree.getData(root).getData());
        System.out.println(binaryTree.getData(binaryTree.getLeftSubtree(root)).getData());
        System.out.println(binaryTree.getData(binaryTree.getRightSubtree(root)).getData());
        System.out.println(binaryTree.getData(binaryTree.getLeftSubtree(bt1)).getData());

        System.out.println("====In Order======");
        binaryTree.inOrderTraverse(root);
        System.out.println("====Pre Order======");
        binaryTree.preOrderTraverse(root);
        System.out.println("====Post Order======");
        binaryTree.postOrderTraverse(root);

        deleteTree(root);

        //change strong reference to weak reference
        root=null;
        bt1=null;
        bt2=null;
        bt3=null;

        // or change to weak reference by method
        weak.clear();
        weakBt1.clear();
        weakBt2.clear();
        weakBt3.clear();

        BinaryTreeIntDataImpl.collect();

        // checking reference of weak object
        System.out.println("Any weak references in Q ? " + (referenceQueue.poll() != null));
        System.out.println("Does the weak reference still hold the heap object ? " + (weak.get() != null));
        System.out.println("Is the weak reference added to the ReferenceQ  ? " + (weak.isEnqueued()));

    }
}
