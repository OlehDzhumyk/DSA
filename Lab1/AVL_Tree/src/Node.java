public class Node {
    public int position;
    public Range range;
    public Node left;
    public Node right;
    public Node parent;
    public Integer data;

    public Node(Node parent) {
        this.left = null;
        this.right = null;
        this.parent = parent;
    }


    public Node right_rotate() {
        Node root = this.left;
        Node beta = this.left.right;
        this.left.right = this;
        this.left = beta;
        return root;
    }

    public Node left_rotate() {
        Node root = this.right;
        Node beta = this.right.left;
        this.right.left = this;
        this.right = beta;
        return root;
    }

    public int find_height() {

        int left_subtree_height = 0;
        int right_subtree_height = 0;

        if (this.left != null)
            left_subtree_height = this.left.find_height() + 1;

        if (this.right != null) {
            right_subtree_height = this.right.find_height() + 1;
        }

        return Math.max(left_subtree_height, right_subtree_height);
    }

    int find_balance_of_node() {
        int left_height = -1;
        int right_height = -1;

        if (this.left != null) {
            left_height = this.left.find_height();
        }
        if (this.right != null) {
            right_height = this.right.find_height();
        }

        return left_height - right_height;
    }

    public Node search_node(int data) {         //gradually moving down to find data
        Node result = this;

        while (data != result.data) {
            if (data < result.data) {
                result = result.left;
            } else {
                result = result.right;
            }
            if (result == null)
                break;
        }
        return result;
    }

    public Node search_parent_node_to_delete(int data) {
        Node local = this;
        Node previous = this;
        while (local.data != data) {
            if (data < local.data) {
                previous = local;
                local = local.left;
            } else {
                previous = local;
                local = local.right;
            }
            if (local == null)
                return null;
        }
        return previous;
    }

    public void setPositionToAllNodes(int width) {

        this.position = this.range.middle();

        if (this.left != null) {
            this.left.range = new Range(this.range.first_value, this.position - 1);
            this.left.setPositionToAllNodes(width);
        }

        if (this.right != null) {
            this.right.range = new Range(this.position + 1, this.range.second_value);
            this.right.setPositionToAllNodes(width);
        }

    }

    public void setPositionToArray(Integer[][] tree, int tilt, int width) {

        tree[this.findHeightRelativeToRoot()][this.position] = this.data;

        if (this.left != null) {
            this.left.setPositionToArray(tree, tilt, width);
        }

        if (this.right != null) {
            this.right.setPositionToArray(tree, tilt, width);
        }

    }

    private int findHeightRelativeToRoot() {
        int height = 0;
        Node currentNode = this;
        while (currentNode.parent != null){
            height++;
            currentNode = currentNode.parent;
        }

        return height;
    }

    public void setParents(Node parent) {
        this.parent = parent;
        if (this.left != null){
            this.left.setParents(this);
        }

        if (this.right != null){
            this.right.setParents(this);
        }
    }
}