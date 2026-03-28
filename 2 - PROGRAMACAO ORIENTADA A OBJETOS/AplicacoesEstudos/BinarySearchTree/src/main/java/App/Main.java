package App;

import java.util.Random;


import Node.Node;
import Node.NodeTree;

public class Main {


    public static void main(String[] args){

        Random random = new Random();
        int number;

        NodeTree tree = new NodeTree();

        for(int i = 0 ; i < 10; i++){
            number = random.nextInt(0, 50);
            System.out.printf("N %d : ", number);
            tree.addNode( new Node(number) );

        }
        
        tree.printTree();
    
        
    }

}
