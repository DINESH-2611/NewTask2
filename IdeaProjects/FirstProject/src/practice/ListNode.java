package practice;

import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = scanner.nextInt();
        ListNode[] listNodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            ListNode head = null;
            ListNode temp = head;
            System.out.println("Enter size of inner linked list");
            int n1 = scanner.nextInt();
            for (int j = 0; j < n1; j++) {
                System.out.println("Enter the value of node");
                int val = scanner.nextInt();
                if (temp == null) {
                    temp = new ListNode(val);
                    head = temp;
                } else {
                    temp.next = new ListNode(val);
                    temp = temp.next;
                }

            }

            listNodes[i] = head;
        }
        display(listNodes);
        ListNode res = null, temp = res;
        ListNode head = listNodes[0];
        for (int i = 1; i < n; i++) {
            ListNode current = listNodes[i];
            while (head != null && current != null) {
                if (head.val <= current.val) {
                    if (temp == null) {
                        temp = new ListNode(head.val);
                        res = temp;
                    } else {
                        temp.next = new ListNode(head.val);
                        temp = temp.next;
                    }
                    head = head.next;
                } else {
                    if (temp == null) {
                        temp = new ListNode(current.val);
                        res = temp;
                    } else {
                        temp.next = new ListNode(current.val);
                        temp = temp.next;
                    }
                    current = current.next;
                }
            }
            ListNode tempNode=res;
            while (tempNode!=null){
                System.out.print(tempNode.val+" ");
                tempNode=tempNode.next;
            }
        }
    }

    private static void display(ListNode[] listNodes) {
        for (int i = 0; i < listNodes.length; i++) {
            ListNode temp = listNodes[i];
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
