// Hsin Li
// 05/04/2024
// Problem 11 + 12 of Spring 2023 Exam
// Description: Linked List function implementation

#include <iostream>
#include <cassert>

using namespace std;

struct Node {
    int data;
    Node *next;
    Node(int data);
    Node(int data, Node *next);
};

typedef Node *ListType;

Node::Node (int data) {
    this->data = data;
    this->next = nullptr;
}

Node::Node (int data, Node *next) {
    this->data = data;
    this->next = next;
}

// Checks if a linked list has exactly two elements
// Checks if the first one is less than the second one
// PRE: list is a well-formed linked list
bool isValid (ListType list) {
    Node *curr = list;
    if (curr == nullptr || curr->next == nullptr || curr->next->next != nullptr) {
        return false;
    }
    if (curr->data >= curr->next->data) {
        return false;
    }
    return true;
}

// PRE: list is a well-formed list with exactly two elements, such that the  
//      first element is less than the second element
// Note: pointer passed by value because the pointer does not change. 
void fillIn (ListType &list) {
    assert (isValid(list));

    Node *curr = list;
    Node *prev = nullptr;
    while (curr != nullptr) {
        if (prev == nullptr) {
            prev = curr;
            curr = curr->next;
        } else {
            if (curr->data != prev->data + 1) {
                prev->next = new Node(prev->data + 1);
                prev->next->next = curr;
                prev = prev->next;
            } else {
                curr = curr->next;
            }
        }
    }

    /* alternative */
    /*
    Node *curr = list;
    while (curr != nullptr && curr->next != nullptr) {
        if (curr->next->data != curr->data + 1) {
            Node *newNode = new Node(curr->data + 1);
            newNode->next = curr->next;
            curr->next = newNode;
        }
        curr = curr->next;
    }
    */
}

void deleteList (ListType &list) {
    Node *temp;
    while (list != nullptr) {
        temp = list;
        list = list->next;
        delete temp;
    }
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

    /* Problem 11 */
    // Test 1: two ascending nodes
    // Excepted: true
    list = new Node(3);
    list->next = new Node(5);
    printList(list);
    cout << boolalpha << isValid(list) << endl;
    deleteList(list);
    
    // Test 2: empty list
    // Expected: false
    printList(list);
    cout << boolalpha << isValid(list) << endl;
    deleteList(list);

    // Test 3: one node list
    // Expected: false
    list = new Node(7);
    printList(list);
    cout << boolalpha << isValid(list) << endl;
    deleteList(list);

    // Test 4: more than two nodes
    // Expected: false
    list = new Node(3);
    list->next = new Node(5);
    list->next->next = new Node(8);
    printList(list);
    cout << boolalpha << isValid(list) << endl;
    deleteList(list);

    // Test 5: non-ascending nodes
    // Expected: false
    list = new Node(6);
    list->next = new Node(2);
    printList(list);
    cout << boolalpha << isValid(list) << endl;
    deleteList(list);

    /* Problem 12 */
    // Test 1: with multiple number in between
    list = new Node(2);
    list->next = new Node(7);
    fillIn(list);
    printList(list);
    deleteList(list);

    // Test 2: with consecutive numbers
    list = new Node(2);
    list->next = new Node(3);
    fillIn(list);
    printList(list);
    deleteList(list);

    return 0;
}
