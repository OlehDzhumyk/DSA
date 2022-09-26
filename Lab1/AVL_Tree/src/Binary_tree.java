public class Binary_tree {
    public Node root;

    Integer[][] tree;

    private void balance_this_tree() {

        if (this.root != null) {

            if (this.root.find_balance_of_node() > 1) {
                if (this.root.left.find_balance_of_node() > 0) {             //left heavy
                    this.root = this.root.right_rotate();                   //right rotate

                } else {
                    this.root.left = this.root.left.left_rotate();            //left right rotate
                    this.root = this.root.right_rotate();
                }
            }

            if (this.root.find_balance_of_node() < -1) {                    //right heavy
                if (this.root.right.find_balance_of_node() < 0) {           //left rotate
                    this.root = this.root.left_rotate();

                } else {
                    this.root.right = this.root.right.right_rotate();      //right left rotate
                    this.root = this.root.left_rotate();
                }
            }
        }
    }

    public void insert(int data) {
        int done = 0;

        Node runNode = this.root;                 // lroot - local root

        if (this.root == null) {                //null root
            this.root = new Node(null);
            this.root.data = data;
            done = 1;
        }

        while (done == 0) {                             //conditions if data has to move left or right
            if (runNode.data > data) {
                if (runNode.left == null) {
                    runNode.left = new Node(runNode);
                    runNode.left.data = data;
                    done = 1;
                } else {
                    runNode = runNode.left;
                }
            } else if (runNode.data < data) {
                if (runNode.right == null) {
                    runNode.right = new Node(runNode);
                    runNode.right.data = data;
                    done = 1;
                } else {
                    runNode = runNode.right;
                }
            } else {
                System.out.println("Already Inserted " + data);
                break;
            }
        }
//        this.balance_this_tree();                       //balance
    }

    public void print_balance() {                    //to check the balance factor of tree
        if (this.root != null)
            System.out.println("Balance Factor: " + this.root.find_balance_of_node());
        else System.out.println("Balance Factor: 0");
    }

    public void search(int data) {
        if (this.root == null) System.out.println("Empty Tree search");
        else {
            if (this.root.search_node(data) == null)
                System.out.println("Not Found " + data);
            else System.out.println(this.root.search_node(data));
        }
    }

    public void delete(int data) {

        if (this.root == null) System.out.println("Empty Tree delete");
        else {
            if (this.root.search_node(data) == this.root) {                 //delete root
                Node save_left_node = this.root.left;
                if (this.root.right == null) {                              //easy case
                    this.root = this.root.left;
                    this.balance_this_tree();
                    System.out.println("Success Delete " + data);

                } else {
                    this.root = this.root.right;
                    Node left_left = this.root;                             //left_left - far left of the right node
                    while (left_left.left != null) {
                        left_left = left_left.left;
                    }
                    left_left.left = save_left_node;
                    this.balance_this_tree();
                    System.out.println("Success Delete " + data);
                }

            } else {                                                            //delete non-root
                Node parent = this.root.search_parent_node_to_delete(data);
                if (parent == null)
                    System.out.println("Doesn't exist " + data);
                else {
                    if (parent.left.data == data) {                                     //from left
                        if (parent.left.left == null && parent.left.right == null) {    //leaf
                            parent.left = null;
                        } else {
                            Node save_left_node = parent.left.left;
                            parent.left = parent.left.right;
                            Node left_left = parent.left;                            //similar to left_left in the upper case
                            while (left_left.left != null) {
                                left_left = left_left.left;
                            }
                            left_left.left = save_left_node;
                        }
                    } else {                                                                       //from right
                        if (parent.right.left == null && parent.right.right == null) {
                            parent.right = null;
                        } else {
                            Node save_left_node = parent.right.left;
                            parent.right = parent.right.right;
                            Node left_left = parent.right;
                            while (left_left.left != null) {
                                left_left = left_left.left;
                            }
                            left_left.left = save_left_node;
                        }
                    }
                    this.balance_this_tree();
                    System.out.println("Success Delete " + data);
                }

            }
        }
    }


    public void printTree() {
        this.root.range = new Range(0, (int) Math.pow(2, this.root.find_height() + 1) - 1);
        this.root.setPositionToAllNodes((int) Math.pow(2, this.root.find_height() + 1) - 1);
        this.tree = new Integer[this.root.find_height() + 1][((int) Math.pow(2, this.root.find_height() + 1)) - 1];
        this.root.setPositionToArray(tree, this.root.find_balance_of_node(), ((int) Math.pow(2, this.root.find_height() + 1)) - 2);

        for (Integer[] integers : tree) {
            for (Integer integer : integers) {
                if (integer == null) {
                    System.out.print("   ");
                } else {
                    if (integer < 10)
                        System.out.print("  ");
                    if (integer >= 10 && integer < 100)
                        System.out.print(" ");
                    System.out.print(integer);

                }
            }
            System.out.println();
        }
    }

    public void setParents() {
        this.root.setParents(null);
    }
}

