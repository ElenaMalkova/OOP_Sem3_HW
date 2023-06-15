

public class main {
    public static void main(String[] args) {
        CustLinkedNodes<String> linkedNodes = new CustLinkedNodes<>();
        linkedNodes.add("Element 01");
        linkedNodes.add("Element 02");
        linkedNodes.add("Element 03");
        linkedNodes.add("Element 04");
        linkedNodes.add("Element 05");

        System.out.println(linkedNodes);

        int index = 3;
        System.out.println("\nContent of Node " + index);
        System.out.println(linkedNodes.getNodeByIndex(index));


    }
}