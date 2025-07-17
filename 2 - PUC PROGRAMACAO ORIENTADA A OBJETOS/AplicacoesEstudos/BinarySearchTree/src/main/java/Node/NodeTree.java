package Node;

/* Binary Search Tree (BST) */
public class NodeTree {
    
    public Node current, root;
    public int currentLevel = 0;

    public NodeTree(){
        root = null;
        current = root;
    }

    public boolean rootEmpty(){
        if(root == null){
            return true;
        }
        return false;
    }

    public boolean leftEmpty(){
        if (current.leftNode == null){
            return true;
        }
        return false;
    }

    public boolean rightEmpty(){
        if (current.rightNode == null){
            return true;
        }
        return false;
    }

    public void gotoNext(int value){
        // go to the lef
        if (value < current.id){
            current = current.leftNode;
        }

        // go to the right
        else{
            current = current.rightNode;
        }

    }
    
    /* 
     * Metodo para inserir um novo nó da arvore 
     * versao mais elegante 
     */
    public void insertNode(Node newNode){

        root = insertNode(newNode, root);
        current = root;
        return;

    }

    /* 
     * Metodo para inserir um novo nó da arvore 
     * versao mais elegante 
     */
    private Node insertNode(Node newNode, Node currentNode){
        
        if(currentNode == null){
            return newNode;
        }

        if(newNode.id < currentNode.id){
            currentNode.leftNode =  insertNode(newNode, currentNode.leftNode);
        }
        else{
            currentNode.rightNode = insertNode(newNode, currentNode.rightNode);
        }

        return currentNode;

    }

    /* 
     * Metodo para inserir um novo nó da arvore
     * primeira versao que elaborei
     */
    public void addNode(Node newNode){
        
        // if tree is empty
        if(root == null){
            root = newNode;
            current = root;
            return;
        }

        // se newNode menor que posição atual então segue para esquerda
        if (newNode.id < current.id){
            // Se espaço esquerda vazio então aloca o newNode 
            if( current.leftNode == null ){
                current.leftNode = newNode;
                return;
            }
            
            current = current.leftNode;
        }

        // se newNode menor que posição atual então segue para direita
        else{
            // Se espaço direita vazio então aloca o newNode 
            if( current.rightNode == null){
                current.rightNode = newNode;
                return;
            }
            
            current = current.rightNode;
        }

        // continua a busca chamando novamente a função
        addNode(newNode);
            
        // reset current
        current = root;

        return;
    }

    public void printTree(){

        
        current = root;
        System.out.printf("\nprimeiro (%d) >> \n", root.id);
        printNode(root,"\n root");
        System.out.printf(" \n<< ultimo (%d) \n",current.id);

    }


    public void printNode(Node node, String position){
               
        if(node == null){
            System.out.printf(position + " (empty) ");        
            return;
        }

        current = node;

        printNode(node.leftNode, String.format("\n [Previous: %d] Left :", node.id));
        System.out.printf("%s %d ", position, node.id);    
        printNode(node.rightNode, String.format("\n [Previous: %d] Right :", node.id));
         
           
        

    }

    void swapRoot(){
        Node newRoot, newCurrent;
        if(current.id < root.id){

            newRoot = current;
            newCurrent = root;

            newRoot.leftNode = root.leftNode;
            newCurrent.leftNode = current.leftNode;

            newRoot.rightNode = root.rightNode;
            newCurrent.rightNode = current.rightNode;                          

        }
    }
}
