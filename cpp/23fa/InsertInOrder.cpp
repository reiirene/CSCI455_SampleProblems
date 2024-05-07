// Hsin Li
// 05/04/2024
// Problem 10 of Fall 2023 Exam
// Description: Linked List structure and implementation

#include <iostream>

using namespace std;

/* Define Node */
struct Node {
    int data;
    Node *next;
    Node(int data);
    Node(int data, Node *next);
};

typedef Node *ListType;

Node::Node(int data) {
    this->data = data;
    this->next = nullptr;
}
Node::Node(int data, Node *next) {
    this->data = data;
    this->next = next;
}

// PRE: list is a well-formed list with elements in non-decreasing order.
void insertInOrder (ListType &list, int newVal) {
    Node *newNode = new Node(newVal);
    Node *curr = list;
    Node *prev = nullptr;
    // list is empty
    if (curr == nullptr) {
        list = new Node(newVal);
    }
    // list not empty
    while (curr != nullptr) {
        if (curr->data < newVal) {      // move on to next node if curr node is smaller than newNode
            prev = curr;
            curr = curr->next;
        } else {                        // if newNode >= curr
            if (prev == nullptr) {      // if curr is the first element in the list
                newNode->next = curr;
                list = newNode;
                break;
            } else {                    // if curr is in the middle of the list
                prev->next = newNode;
                newNode->next = curr;
                break;
            }
        }
    }
}

// deletes and reclaims memory used by the list
void deleteList (ListType &list) {
    Node *curr = list;
    while (curr != nullptr) {
        Node *temp = curr;
        curr = curr->next;
        delete temp;
    }
    list = nullptr;
}

void printList (ListType list) {
    Node *curr = list;
    while (curr != nullptr) {
        cout << curr->data << " ";
        curr = curr->next;
    }
    cout << endl;
}

int main () {
    ListType list;

    // Test 1
    // Expected: (2 3 7 10 13)
    list = new Node(2);
    list->next = new Node(7);
    list->next->next = new Node(10);
    list->next->next->next = new Node(13);
    insertInOrder(list, 3);
    printList(list);
    deleteList(list);

    // Test 2
    // Expected: (-5 2 7 10 13)
    list = new Node(2);
    list->next = new Node(7);
    list->next->next = new Node(10);
    list->next->next->next = new Node(13);
    insertInOrder(list, -5);
    printList(list);
    deleteList(list);

    // Test 3
    // Expected: (2 2 2 5 100)
    list = new Node(2);
    list->next = new Node(2);
    list->next->next = new Node(2);
    list->next->next->next = new Node(5);
    insertInOrder(list, 100);
    printList(list);
    deleteList(list);

    // Test 4
    // Expected: (1 3 3 3 5)
    list = new Node(1);
    list->next = new Node(3);
    list->next->next = new Node(3);
    list->next->next->next = new Node(5);
    insertInOrder(list, 3);
    printList(list);
    deleteList(list);

    // Test 5
    // Expected: (5)
    list = nullptr;
    insertInOrder(list, 5);
    printList(list);
    deleteList(list);

    return 0;
}
