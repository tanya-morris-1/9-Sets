public class main {

    public static void main(String[] args) {
        //BinaryTree test_tree = new BinaryTree();
        //test_tree.root = new BinaryTreeNode(1);
       // test_tree.add_value(1);
        //test_tree.root.right = new BinaryTreeNode(2);
       // test_tree.add_value(2);
        //test_tree.root.right.right = new BinaryTreeNode(3);
       // test_tree.add_value(3);
        //test_tree.root.right.right.right = new BinaryTreeNode(4);
      //  test_tree.add_value(4);

       //System.out.print("\nBinary Tree: ");
      //  System.out.print(test_tree.traverse_tree_1(test_tree.root));

        SearchSet test_set = new SearchSet();
        test_set.insert(1);
        test_set.insert(2);
        test_set.insert(3);
        test_set.insert(4);
        //test_set.search_set();
        System.out.println(test_set.contains(12));
        System.out.println(test_set.getNumberElements());

        FunctionalArray test_array = new FunctionalArray(3);

        BinaryTree test_tree = new BinaryTree();


        test_tree.add_value(1);
        test_tree.add_value(3);
        //int result = test_tree.traverse_tree_to_fetch_index(test_tree.root, 2);
       // System.out.println(result);

    }
}