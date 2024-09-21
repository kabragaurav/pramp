/*
The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily binary). The root is the company itself, and every node in the tree represents a car distributor that receives cars from the parent node and ships them to its children nodes. The leaf nodes are car dealerships that sell cars direct to consumers. In addition, every node holds an integer that is the cost of shipping a car to it.
Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.

Implement your function in the most efficient manner and analyze its time and space complexities.
Constraints:

[time limit] 5000ms

[input] Node rootNode

0 ≤ rootNode.cost ≤ 100000
[output] integer
 */

class SalesPathSolution {

    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {
        int getCheapestCost(Node root) {
            if (root == null) {
                return 0;
            }
            return helper(root);
            }

            private int helper(Node root) {
            if (root.children == null || root.children.length == 0) {
                return root.cost;
            }
            int min = Integer.MAX_VALUE;
            for (Node child : root.children) {
                min = Math.min(min, helper(child));
            }
            return root.cost + min;
        }
    }
        
    /*********************************************
    * Driver program to test above method     *
    *********************************************/

    public static void main(String[] args) {
        // Creating a sample tree
        Node root = new Node(5);
        Node child1 = new Node(10);
        Node child2 = new Node(3);
        Node child11 = new Node(2);
        Node child21 = new Node(7);
        Node child22 = new Node(1);

        root.children = new Node[]{child1, child2};
        child1.children = new Node[]{child11};
        child2.children = new Node[]{child21, child22};

        SalesPath salesPath = new SalesPath();
        int cheapestCost = salesPath.getCheapestCost(root);
        System.out.println("Cheapest Cost: " + cheapestCost); // Expected output should be the minimum cost path
    }
}