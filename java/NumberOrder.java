// ouput numbers 0, 1, 2, 3, ...., n in lexical order

import java.util.*;

class NumberOrder {
        public static void main(String[] args) {
            NumberOrder no = new NumberOrder();
            System.out.println(no.getNumbers(10000));
        }

        class Node {
            int val;
            Node[] children;

            public Node(int val) {
                this.val = val;
                children = new Node[10];
            }
        }

        void buildTree(Node node, int n) {
            if (node.val == 0)
                return;

            int val = node.val;
            if (val < 0)
                val = 0;

            for (int i = 0; i < 10; ++i) {
                int newVal = 10 * val + i;
                if (newVal > n)
                    break;
                node.children[i] = new Node(newVal);
                buildTree(node.children[i], n);
            }
        }

        void transverse(Node node, List<Integer> lst) {
            if (node == null)
                return;
            if (node.val >= 0)
                lst.add(node.val);
            for (Node child: node.children) {
                transverse(child, lst);
            }
        }

        public List<Integer> getNumbers(int n) {
            List<Integer> res = new ArrayList<>();
            Node root = new Node(-1);
            buildTree(root, n);
            transverse(root, res);

            return res;
        }
}
