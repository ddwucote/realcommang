package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5639 {
    static class Node {
        int num;
        Node l, r;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.l = left;
            this.r = right;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.l == null)
                    this.l = new Node(n);
                else this.l.insert(n);
            } else {
                if (this.r == null)
                    this.r = new Node(n);
                else this.r.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String num;
        while (true) {
        	num = br.readLine();
            if (num == null || num.equals(""))
                break;
            root.insert(Integer.parseInt(num));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.l);
        postOrder(node.r);
        System.out.println(node.num);
    }
}