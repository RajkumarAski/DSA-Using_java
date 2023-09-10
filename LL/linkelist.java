package LL;
class LL {
    class Node{
        String data;
        Node next;

    Node(String data){
        this.data=data;
        this.next=null;
    }
    }
    Node head;
    // add first
    public void addFirst(String data){
        Node newNode=new Node(data);
        
        if (head == null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    //add last
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node curNode=head;
        while(curNode.next!=null){ 
            curNode=curNode.next;
        }
        curNode.next=newNode;

    }
    // print values
    public void printList(){
        if(head==null){
            System.out.print("Empty");
            return;
        }
        Node curNode=head;
        while(curNode!=null){ 
            System.out.print(curNode.data+"-->");
            curNode=curNode.next;
        }
        System.out.print("null");
    }
    //delete last node
    public void deleteLast(){
         if(head==null){
            System.out.print("Empty");
            return;
        }
        Node secondlast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondlast=secondlast.next;
        }
            secondlast.next=null;
    }
    //Reverse by Iterativly
    public void reverseIterate(){
        Node prev=head;
        Node curr=head.next;
        while(curr!=null){
            Node nextNode=curr.next;
            curr.next=prev;
            //update
            prev=curr;
            curr=nextNode;
        }
        head.next=null;
        head=prev;
    }
    //reverse by recursion
    public Node reverseRecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newNode=reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;

    }
    public static void main(String[] args) {
        // just try below elements for testing
        LL list=new LL();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addLast("d");
        list.deleteLast();
        list.printList();
        //list.reverseIterate();
        list.head=list.reverseRecursive(list.head);
        list.printList();

    }
}
