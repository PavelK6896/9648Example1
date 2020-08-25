package tree;

class Node {
    public Person person;

    public Node leftChild;
    public Node rightChild;

    public void display() {
        if (person.name <= 9) {
            if (person.name >= 0) {
                System.out.print("( " + person.name + " )");
                return;
            }

            if (person.name > -9) {
                System.out.print("(" + person.name + " )");
                return;
            }

            if (person.name > -99) {
                System.out.print("(" + person.name + ")");
                return;
            }

        }else {

            if (person.name <= 99) {
                System.out.print("( " + person.name + ")");
                return;

            }

        }

    }
}
