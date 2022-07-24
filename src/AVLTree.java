class Node
{
    Node left,right;
    int data;
    int height;
    Node(int data)
    {
        height=1;
        this.data=data;
    }
}
public class AVLTree
{
    static int Balance_fac(Node x)
    {
        if(x==null)
            return 0;
        return Height(x.left)-Height(x.right);
    }

    static Node  Rotate_left(Node x)
    {
        Node y=x.right;   // y holds the right subtree of x
        Node TempL =y.left;// TempL holds the left subtree of y
                          // as it is to be placed in right of x later


        y.left=x;         // we put x in left of y because x < y
        x.right=TempL;    // x.right==y.left now left subtree of y
                          // will also be > x so it will go in the right of x

        // Update the height of the x and y
        x.height=Math.max(Height(x.left),Height(x.right))+1;
        y.height=Math.max(Height(y.right),Height(y.left))+1;


        return y;         // now x link is broken and the ancestor of x will get y
    }

    static Node Rotate_right(Node x)
    {
        Node y=x.left;
        Node TempR=y.right;

        y.right=x;
        x.left=TempR;

        x.height=Math.max(Height(x.left),Height(x.right))+1;
        y.height=Math.max(Height(y.right),Height(y.left))+1;

        return y;
    }
    public static int Height(Node x)
    {
        if(x==null)
            return 0;
        return x.height;
    }
    public static Node Insert_AVL(Node x,int  data)
    {
        if(x==null)
        {
            return new Node(data);
        }
        if(x.data<data)
        {
            x.right=Insert_AVL(x.right,data);
        }
        else if(x.data>data) {
            x.left=Insert_AVL(x.left,data);
        }
        else
        {
            System.out.println("DUPLICATE DATA!!!!!!");
            return x;
        }
        x.height=1+Math.max(Height(x.left),Height(x.right)); // Incrementing/initializing Height of the nodes in reverse order

        //Rotation cases
        int balance=Balance_fac(x);// returns the balance factor of the current Node

        // LEFT LEFT CASE
        if(balance>1 && x.left.data>data)
        {
            return Rotate_left(x);
        }

        // LEFT RIGHT CASE
        if(balance>1 && x.left.data<data)
        {
            x.left=Rotate_left(x.left);
            return Rotate_right(x);
        }

//         RIGHT LEFT CASE
        if(balance<-1 && x.right.data>data)
        {
            x.right=Rotate_right(x.right);
            return Rotate_left(x);
        }

        // RIGHT RIGHT CASE
        System.out.println();
        if(balance>1 && x.left.data>data)
        {
            return Rotate_right(x);
        }

        return x;
    }
    public static void Print(Node x)
    {
        if(x!=null) {
            System.out.print(x.data + " ");
            Print(x.left);
            Print(x.right);
        }
    }
    public static void main(String[] args)
    {

        Node root=new Node(500);
        root=Insert_AVL(root,200);
        root=Insert_AVL(root,300);
        System.out.println(root.data);
    Print(root);

    }
}
// Java program for insertion in AVL Tree
//class Node {
//    int key, height;
//    Node left, right;
//
//    Node(int d) {
//        key = d;
//        height = 1;
//    }
//}
//
//class AVLTree {
//
//    Node root;
//
//    // A utility function to get the height of the tree
//    int height(Node N) {
//        if (N == null)
//            return 0;
//
//        return N.height;
//    }
//
//    // A utility function to get maximum of two integers
//    int max(int a, int b) {
//        return (a > b) ? a : b;
//    }
//
//    // A utility function to right rotate subtree rooted with y
//    // See the diagram given above.
//    Node rightRotate(Node x) {
//        Node y = x.left;
//        Node T2 = y.right;
//
//        // Perform rotation
//        y.right = x;
//        x.left = T2;
//
//        // Update heights
//        y.height = max(height(y.left), height(y.right)) + 1;
//        x.height = max(height(x.left), height(x.right)) + 1;
//
//        // Return new root
//        return x;
//    }
//
//    // A utility function to left rotate subtree rooted with x
//    // See the diagram given above.
//    Node leftRotate(Node x) {
//        Node y = x.right;
//        Node T2 = y.left;
//
//        // Perform rotation
//        y.left = x;
//        x.right = T2;
//
//        // Update heights
//        x.height = max(height(x.left), height(x.right)) + 1;
//        y.height = max(height(y.left), height(y.right)) + 1;
//
//        // Return new root
//        return y;
//    }
//
//    // Get Balance factor of node N
//    int getBalance(Node N) {
//        if (N == null)
//            return 0;
//
//        return height(N.left) - height(N.right);
//    }
//
//    Node insert(Node node, int key) {
//
//        /* 1. Perform the normal BST insertion */
//        if (node == null)
//            return (new Node(key));
//
//        if (key < node.key)
//            node.left = insert(node.left, key);
//        else if (key > node.key)
//            node.right = insert(node.right, key);
//        else // Duplicate keys not allowed
//            return node;
//
//        /* 2. Update height of this ancestor node */
//        node.height = 1 + max(height(node.left),
//                height(node.right));
//
//		/* 3. Get the balance factor of this ancestor
//			node to check whether this node became
//			unbalanced */
//        int balance = getBalance(node);
//
//        // If this node becomes unbalanced, then there
//        // are 4 cases Left Left Case
//        if (balance > 1 && key < node.left.key)
//            return rightRotate(node);
//
//        // Right Right Case
//        if (balance < -1 && key > node.right.key)
//            return leftRotate(node);
//
//        // Left Right Case
//        if (balance > 1 && key > node.left.key) {
//            node.left = leftRotate(node.left);
//            return rightRotate(node);
//        }
//
//        // Right Left Case
//        if (balance < -1 && key < node.right.key) {
//            node.right = rightRotate(node.right);
//            return leftRotate(node);
//        }
//
//        /* return the (unchanged) node pointer */
//        return node;
//    }
//
//    // A utility function to print preorder traversal
//    // of the tree.
//    // The function also prints height of every node
//    void preOrder(Node node) {
//        if (node != null) {
//            System.out.print(node.key + " ");
//            preOrder(node.left);
//            preOrder(node.right);
//        }
//    }
//
//    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//
//        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 25);
//        tree.root = tree.insert(tree.root, 9);
//        tree.root = tree.insert(tree.root, 22);
//        tree.root = tree.insert(tree.root, 15);
//        tree.root = tree.insert(tree.root, 11);
//
//		/* The constructed AVL Tree would be
//			30
//			/ \
//		20 40
//		/ \	 \
//		10 25 50
//		*/
//        System.out.println("Preorder traversal" +
//                " of constructed tree is : ");
//        tree.preOrder(tree.root);
//    }
//}
//// This code has been contributed by Mayank Jaiswal
//
