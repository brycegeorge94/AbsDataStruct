#ifndef BST_NODE
#define BST_NODE

class Node {
    public:
        Node(int value, Node *left, Node * right);
        Node(Node &other);
        ~Node();
    
    private:
        int value;
        Node *left;
        Node *right;
};

#endif // BST_NODE