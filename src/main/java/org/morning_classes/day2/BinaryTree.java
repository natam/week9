package org.morning_classes.day2;

public class BinaryTree {
    private TreeNode root;

    public void addNode(int value){
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.getValue()) {
            current.setLeftNode(addRecursive(current.getLeftNode(), value));
        } else if (value > current.getValue()) {
            current.setRightNode(addRecursive(current.getRightNode(), value));
        } else {
            return current;
        }
        return current;
    }

    private void printRecursive(TreeNode current) {
        if (current != null) {
            System.out.println(current.getValue());
            if (current.getLeftNode() != null) {
                printRecursive(current.getLeftNode());
            }
            if (current.getRightNode() != null) {
                printRecursive(current.getRightNode());
            }
        }
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if(current.getValue()==value){
            return true;
        }
        if(current.getValue()>value){
            return containsNodeRecursive(current.getRightNode(), value);
        }else {
            return containsNodeRecursive(current.getLeftNode(), value);
        }
    }

    public boolean containsNode(int value){
        return containsNodeRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode currentNode, int value){
        if(currentNode == null){
            return null;
        }
        if(currentNode.getValue()==value){
            if(currentNode.getRightNode()==null && currentNode.getLeftNode()==null){
                return null;
            }else if(currentNode.getLeftNode()==null){
                return currentNode.getRightNode();
            }else if (currentNode.getRightNode()==null){
                return currentNode.getLeftNode();
            }else {

            }
        }
        if(currentNode.getValue()>value){
            return deleteRecursive(currentNode.getLeftNode(), value);
        }else {
            return deleteRecursive(currentNode.getRightNode(), value);
        }
    }

    private static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.addNode(6);
        bt.addNode(4);
        bt.addNode(8);
        bt.addNode(3);
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(9);
        bt.addNode(9);
        bt.addNode(33);
        bt.addNode(39);
        return bt;}


    public static void main(String[] args) {
        BinaryTree myTree = createBinaryTree();
        myTree.printRecursive(myTree.root);

    }

}
