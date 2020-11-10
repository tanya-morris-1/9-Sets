

class BinaryTreeNode {
    int mValue;                         // Creates each node to have a value, and a left and right subtree.
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value){
        mValue = value;                         // This initialises the value the branch holds, and sets
        left = null;                        // the subnodes to null, as they do not need to be filled immediately.
        right = null;
    }

    public int getValue(){
        return mValue;
    }               // Returns value of node.

    public void setValue(int value){
        mValue = value;
    }     // Sets value of node.

    public BinaryTreeNode getLeft() {
        return left;
    }           // Returns left subnode.

    public BinaryTreeNode getRight() {
        return right;
    }       // Returns right subnode.

    public void setLeft(BinaryTreeNode node){
        left = node;
    }          // Given an node, sets the left node to be this.

    public void setRight(BinaryTreeNode node){
        right = node;
    }       // Sets the right node.
}

class BinaryTree {
    BinaryTreeNode root;                // Creates the root of the tree as a BinaryTreeNode.
    String result = "";             // I use this to traverse the tree (I think this implementation is what made part b)
                                    // overly hard.

    public String traverse_tree(BinaryTreeNode node){
        if (node != null) {                     // The top node has to not be null in order for this part to be searched
            traverse_tree(node.left);           // Traverses the left side first, recursively.
            result += (node.mValue) + " " ;     // As each value is searched, I add it to a string, with a space between them.
            traverse_tree(node.right);
        }
        return result;      // If the node was null, the result is returned as is, there was nothing to add to the search.
    }

    public String traverse_tree_1(BinaryTreeNode node){
        if (result != "") { result = ""; }      // This is like a wrapper function, which empties the result if it was full.
        return traverse_tree(node);
    }


    // This was my attempt at part b), but I had lots of issues with it and ultimately had to move on to the rest of the
    // questions in order to have time to complete them all.

  /*  public int traverse_tree_to_fetch_index(BinaryTreeNode node, int index) {
        int to_return = 0;
        try {
            to_return = 0;
            boolean found = false;
            while (index_to_pass != index) {
                traverse_tree(node.left);
                index_to_pass += 1;
                if (index_to_pass == index) {
                    to_return = (node.mValue);
                    found = true;
                    break;
                }
                traverse_tree(node.right);
            }
            if (found == true) {
                return to_return;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return to_return;
    }

    int index_to_pass = 0;

    public String traverse_tree_index(BinaryTreeNode node, int index){
        if (index_to_pass != 0) {index_to_pass = 0;};
        return traverse_tree(node);
    }  */



    private BinaryTreeNode add_value_recursive(BinaryTreeNode node, int value){         // This is a fucntion to add a new node
                                                                                                // with inputted value.
        if (node == null){              // If the starting node is null, then a new node is made here with value.
            return new BinaryTreeNode(value);

        }

        // If the value of the current node is greater than the inputted value, we recursively search the left tree to find
        // where the new node should be placed (as all smaller items go to the left, and larger to the right).
            if (node.mValue>value) {
                node.left = add_value_recursive(node.left, value);
            }
            else if (node.mValue<value){
                node.right = add_value_recursive(node.right, value);        // Else we search the right tree.
            }
            else {
                return node;        // Otherwise, it must be equal to the current node, hence we just return the current node.
            }
            return node;

    }

    public void add_value(int value) {
        root = add_value_recursive(root,value);
    }    // Wrapper function that passes the root into function.



}

class SearchSet {
    int mElements;                  // Elements to be passed in.
    BinaryTree treeImplementation = new BinaryTree();       // Implementation of a binary tree.

    public void insert(int value){
        treeImplementation.add_value(value);
    }       // Uses the add_value function of BinaryTree.

    public String search_set(){
        String s = treeImplementation.traverse_tree_1(treeImplementation.root);
        return s;           // This returns a string of all of the items in the tree.
    }

    public boolean contains(int checking){      // Checks whether inputted item is present in tree.
        boolean to_return = false;               // Initially set to false, only becomes true if item is found.
        String list_of_el = search_set();
        String[] list_split = list_of_el.split(" ");    // Splits string into a list of values in tree.
        for (String e : list_split) {       // Goes through each item in list.
            if (Integer.parseInt(e) == checking){       // Converts item to integer and checks if it is equal to what is being searched for.
                to_return = true;           // If it is equal, to_return is set to true.
            }
        }
        return to_return;
    }

    public int getNumberElements(){
        String list_of_el = search_set();
        String[] list_split = list_of_el.split(" ");    // In same way as above, list of elements is found.
        return list_split.length;       // Length returned.
    }
}

class FunctionalArray{
    BinaryTree treeImplementation = new BinaryTree();

    FunctionalArray(int size) {
        for (int i = 0; i<size; i++){
            treeImplementation.add_value(0);    // This was meant to initialise a tree of a set size.
        }
    }


    int get(int index){     // This was meant to fetch the item at the index. I struggled to implement this as my
                            // traversal using an index was not correct.
        String s = treeImplementation.traverse_tree_1(treeImplementation.root);
        String[] list_split = s.split(" ");
        int to_return = 0;
        int i = 0;
        for (String element : list_split){
            i++;
            if (i == index) {
                to_return = Integer.parseInt(element);
            }
        }
        return to_return;
    }



}
