public class LinkedBag implements BagInterface {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean addNewEntry(Building newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNext(this.firstNode);
        this.firstNode = newNode;
        this.numberOfEntries++;
        return true;
    }

    public Building remove() {
        return null;
    }

    public boolean remove(Building anEntry) {
        return false;
    }

    public void clear() {

    }
    public int getFrequencyOf(Building anEntry) {
        return 0;
    }

    public boolean contains(Building anEntry) {
        return false;
    }

    public String toString() {
        String resultStr = "Bag [ \n";
        Node currentNode = this.firstNode;
        while (currentNode != null) {
            resultStr += currentNode.getData() + "\n";
            currentNode = currentNode.getNext();

        }
        resultStr += "] \n";
        return "";
    }
}