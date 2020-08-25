package tree;

class Tree {

    private Node nodeRoot;
    private int r;

    public boolean balans3() {
        boolean balans = false;
        r = 0;
        int right = balans2(nodeRoot.rightChild);

        r = 0;
        int left = balans2(nodeRoot.leftChild);
        System.out.println(left + " | " + right);

        if (Math.abs(right - left) <= 1) {
            balans = true;
        }
        return balans;
    }

    public int balans2(Node current) {
        if (current == null) {
            return r;
        } else {
            r++;
        }

        if (current.rightChild == null && current.leftChild == null) {
            return r;
        } else {
            balans2(current.rightChild);
            balans2(current.leftChild);
        }
        return r;
    }


    public Node find(int key) {
        Node current = nodeRoot;
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (nodeRoot == null) {
            nodeRoot = node;
        } else {
            Node current = nodeRoot;
            Node parent;
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int id) {
        Node current = nodeRoot;
        Node parent = nodeRoot;
        boolean isLeftChild = true;

        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        // Если узел не имеет потомков

        if (current.leftChild == null && current.rightChild == null) {
            if (current == null) {
                nodeRoot = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка
        else if (current.rightChild == null) {
            if (current == null) {
                nodeRoot = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        // Если нет левого потомка
        else if (current.leftChild == null) {
            if (current == null) {
                nodeRoot = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if (current == nodeRoot) {
                nodeRoot = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccesor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("traverse");
                preOrder(nodeRoot);
                break;
        }
    }

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public void displayTree() {
        int leval = 1;
        Stack stack = new Stack(100);

        stack.push(this.nodeRoot);

        System.out.println();

        int nBlanks = 10;

        System.out.println(nBlanks);

        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            System.out.print("leval " + leval + ":");


            Stack localStack = new Stack(100);
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print("     ");
            }

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node != null) {
                    node.display();
                    localStack.push(node.leftChild);
                    localStack.push(node.rightChild);
                    if (node.leftChild != null || node.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("(   )");
                    localStack.push(null);
                    localStack.push(null);
                }
            }

            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("");
            nBlanks = nBlanks - leval;
            leval++;

        }
        System.out.println("----------------------------------");
        System.out.print("!end ");

    }


}
