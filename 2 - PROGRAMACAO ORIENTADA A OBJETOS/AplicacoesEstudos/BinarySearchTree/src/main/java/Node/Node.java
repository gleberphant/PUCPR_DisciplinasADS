package Node;

public class Node {
    public int id;
    public Node leftNode = null;
    public Node rightNode = null;

    public Node(int id){
        this.id = id;
        leftNode = null;
        rightNode = null;
    }

    Node getLeftNode(){
        return leftNode;
    }

    Node getRighNode(){
        return rightNode;
    }

    int getId(){
        return id;
    }

}
