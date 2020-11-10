import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class BinaryTreeNodeTest {
    @Test
    public void tree_sets_root(){

        // ARRANGE
        BinaryTree test_tree = new BinaryTree();

        // ACT
        test_tree.add_value(1);
        int result = test_tree.root.getValue();

        //ASSERT
        assertThat(result).isEqualTo(1);

    }

    @Test
    public void tree_traverses(){

        // ARRANGE
        BinaryTree test_tree = new BinaryTree();

        // ACT
        test_tree.add_value(1);
        test_tree.add_value(2);
        test_tree.add_value(3);
        test_tree.add_value(4);
        String result = test_tree.traverse_tree_1(test_tree.root);

        //ASSERT
        assertThat(result).isEqualTo("1 2 3 4 ");

    }


    @Test
    public void node_functions_work(){

        // ARRANGE
        BinaryTreeNode test_node = new BinaryTreeNode(5);

        // ACT
        test_node.setLeft(test_node);

        int result = (test_node.getLeft()).getValue();
        //ASSERT
        assertThat(result).isEqualTo(5);

    }

    @Test
    public void node_functions_work_right(){

        // ARRANGE
        BinaryTreeNode test_node = new BinaryTreeNode(10);

        // ACT
        test_node.setRight(test_node);

        int result = (test_node.getRight()).getValue();
        //ASSERT
        assertThat(result).isEqualTo(10);

    }

    @Test
    public void search_set_insert_works(){

        // ARRANGE
        SearchSet test_set = new SearchSet();

        // ACT
        test_set.insert(1);
        test_set.insert(2);
        test_set.insert(3);
        test_set.insert(4);

        String result = test_set.search_set();
        //ASSERT
        assertThat(result).isEqualTo("1 2 3 4 ");

    }

    @Test
    public void search_set_contains_returns_true(){

        // ARRANGE
        SearchSet test_set = new SearchSet();

        // ACT
        test_set.insert(1);
        test_set.insert(2);
        test_set.insert(3);
        test_set.insert(4);

        boolean result = test_set.contains(3);
        //ASSERT
        assertThat(result).isEqualTo(true);

    }

    @Test
    public void search_set_contains_returns_false(){

        // ARRANGE
        SearchSet test_set = new SearchSet();

        // ACT
        test_set.insert(1);
        test_set.insert(2);
        test_set.insert(3);
        test_set.insert(4);

        boolean result = test_set.contains(10);
        //ASSERT
        assertThat(result).isEqualTo(false);

    }

    @Test
    public void search_set_get_no_elements(){

        // ARRANGE
        SearchSet test_set = new SearchSet();

        // ACT
        test_set.insert(1);
        test_set.insert(2);
        test_set.insert(3);
        test_set.insert(4);

        int result = test_set.getNumberElements();
        //ASSERT
        assertThat(result).isEqualTo(4);

    }




}



