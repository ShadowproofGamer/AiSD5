public class BST {
    // BST root node
    private Node root;
    private int height;

    // Constructor for BST =>initial empty tree
    public BST() {
        root = null;
        height = -1;
    }

    //delete a node from BST
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    //recursive delete function
    private Node deleteRecursive(Node root, int key) {
        //tree is empty
        if (root == null) return root;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = deleteRecursive(root.right, key);
        else {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }

    public int findMin() {
        return minValue(root);
    }

    public int minValue(Node root) {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    public int findMax() {
        return maxValue(root);
    }

    public int maxValue(Node root) {
        //initially minval = root
        int minval = root.key;
        //find maxval
        while (root.right != null) {
            minval = root.right.key;
            root = root.right;
        }
        return minval;
    }

    private Node minValueNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node maxValueNode(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // insert a node in BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    //recursive insert function
    private Node insertRecursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            //root.p=null;
            return root;
        }
        //traverse the tree
        else if (key < root.key)     //insert in the left subtree
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insertRecursive(root.right, key);
        // return pointer
        return root;
    }

    private Node insertRecursive(Node root, int key, Node parent) {
        //tree is empty
        if (root == null) {
            root = new Node(key, parent);
            //root.p=null;
            return root;
        }
        //traverse the tree
        else if (key < root.key)     //insert in the left subtree
            root.left = insertRecursive(root.left, key, root);
        else if (key > root.key)    //insert in the right subtree
            root.right = insertRecursive(root.right, key, root);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    public void inorder() {
        inorderRecursive(root);
    }

    // recursively traverse the BST
    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    public int count() {
        return counterRecursive(root, 0);
    }

    private int counterRecursive(Node root, int result) {
        if (root != null) {
            result++;
            result += counterRecursive(root.left, 0);
            result += counterRecursive(root.right, 0);
        }
        return result;
    }

    public int heightCount() {
        heightCounterRecursive(root, -1);
        return height;
    }

    private int heightCounterRecursive(Node root, int result) {
        if (root != null) {
            result++;
            int l = heightCounterRecursive(root.left, result);
            if (l > height) height = result;
            int r = heightCounterRecursive(root.right, result);
            if (r > height) height = result;

        }
        return result;
    }

    public int countEven() {
        return counterEvenRecursive(root, 0);
    }

    private int counterEvenRecursive(Node root, int result) {
        if (root != null) {
            if (root.key % 2 == 0) result++;
            result += counterEvenRecursive(root.left, 0);
            result += counterEvenRecursive(root.right, 0);
        }
        return result;
    }

    public int countOneChild() {
        return counterOneChildRecursive(root, 0);
    }

    private int counterOneChildRecursive(Node root, int result) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                result++;
                result += counterOneChildRecursive(root.right, 0);

            } else if (root.left != null && root.right == null) {
                result++;
                result += counterOneChildRecursive(root.left, 0);
            }
            else {
                result += counterOneChildRecursive(root.right, 0);
                result += counterOneChildRecursive(root.left, 0);
            }


        }
        return result;
    }

    public int countOneBro() {
        int result = 0;
        heightCount();
        int[] arr = counterOneBroRecursive(root, new int[height + 1], 0);
        for (int i : arr) {
            if (i == 2) result += 2;
        }
        return result;
    }

    private int[] counterOneBroRecursive(Node root, int[] result, int h) {
        if (root != null) {
            result[h]++;
            result = counterOneBroRecursive(root.left, result, h + 1);
            result = counterOneBroRecursive(root.right, result, h + 1);
        }
        return result;
    }

    public int countOneChildHeight() {
        return counterOneChildHeightRecursive(root, 0, 0, -1, -1);
    }

    private int counterOneChildHeightRecursive(Node root, int result, int max, int index, int temp) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                if (index == -1) {
                    index = root.key;
                    temp = root.key;
                }
                result++;
                index = counterOneChildHeightRecursive(root.right, result, max, index, temp);

            } else if (root.left != null && root.right == null) {
                if (index == -1) {
                    index = root.key;
                    temp = root.key;
                }
                result++;
                index = counterOneChildHeightRecursive(root.left, result, max, index, temp);

            } else if (root.left != null) {
                if (result > max) {
                    index = temp;
                    max = result;
                }
                counterOneChildHeightRecursive(root.left, 0, max, index, root.left.key);
                counterOneChildHeightRecursive(root.right, 0, max, index, root.right.key);
            }

        }
        return index;
    }


    public boolean search(int key) {
        Node r = searchRecursive(root, key);
        return r != null;
    }

    //recursive insert function
    public Node searchRecursive(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return searchRecursive(root.left, key);
        // val is less than root's key
        return searchRecursive(root.right, key);
    }


    //node class that defines BST node
    private class Node {
        public Node p;
        public int key;
        public Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }

        public Node(int data, Node parent) {
            key = data;
            left = right = null;
        }
    }
}

