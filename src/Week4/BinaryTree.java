/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week4;

import java.util.Scanner;

class Node {
    Node left;
    int value;
    Node right;
    
    public Node(int val){
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    
    static Node root;
    
    static Node insert(Node current, int val) {
        if(current == null){
            return new Node(val);
        }
        if (val < current.value) {
            current.left = insert(current.left, val);
        } else if (val > current.value) {
            current.right = insert(current.right, val);
        } else {
            return current;
        }

    return current;
    }
    
    static void add(int val){
        
    }
    
    public static void main(String args[]) {
        Scanner inp = new Scanner (System.in);
        System.out.println("Banyaknya node: ");
        int banyakNode = inp.nextInt();
        
        
    }
}
