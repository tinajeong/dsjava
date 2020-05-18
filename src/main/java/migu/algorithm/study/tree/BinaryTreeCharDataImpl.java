package migu.algorithm.study.tree;

import migu.algorithm.study.data.BiTreeCharDataNode;

public class BinaryTreeCharDataImpl implements BinaryTree<BiTreeCharDataNode> {
    @Override
    public BiTreeCharDataNode makeBiTreeDataNode() {
        return new BiTreeCharDataNode();
    }

    @Override
    public BiTreeCharDataNode getLeftSubtree(BiTreeCharDataNode main) {
        return (BiTreeCharDataNode) main.getLeft();
    }

    @Override
    public BiTreeCharDataNode getRightSubtree(BiTreeCharDataNode main) {
        return (BiTreeCharDataNode) main.getRight();
    }

    @Override
    public void makeLeftSubtree(BiTreeCharDataNode main, BiTreeCharDataNode sub) {
        if(main.getLeft()!=null)
            main.setLeft(null);
        main.setLeft(sub);
    }

    @Override
    public void makeRightSubtree(BiTreeCharDataNode main, BiTreeCharDataNode sub) {
        if(main.getRight()!=null)
            main.setRight(null);
    }

    @Override
    public void inOrderTraverse(BiTreeCharDataNode main) {
        if(main==null)
            return;
        inOrderTraverse((BiTreeCharDataNode) main.getLeft());
        System.out.println(main.getData());
        inOrderTraverse((BiTreeCharDataNode) main.getRight());
    }

    @Override
    public void preOrderTraverse(BiTreeCharDataNode main) {
        if(main==null)
            return;
        System.out.println(main.getData());
        preOrderTraverse((BiTreeCharDataNode) main.getLeft());
        preOrderTraverse((BiTreeCharDataNode) main.getRight());
    }

    @Override
    public void postOrderTraverse(BiTreeCharDataNode main) {
        if(main==null)
            return;
        postOrderTraverse((BiTreeCharDataNode) main.getLeft());
        postOrderTraverse((BiTreeCharDataNode) main.getRight());
        System.out.println(main.getData());
    }
}
