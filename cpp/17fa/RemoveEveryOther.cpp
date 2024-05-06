// Hsin Li
// 05/04/2024
// Problem 9 of Fall 2017 Exam
// Description: C++ implementation of removeEveryOther function

#include <iostream>
#include <vector>

using namespace std;

/* Define Node */
struct Node {
    int data;
    Node* next;
    Node(int val);
    Node(int val, Node *next);
};

typedef Node* ListType;

Node::Node(int val) {
    this->data = val;
    this->next = nullptr;
}
Node::Node(int val, Node* next) {
    this->data = val;
    this->next = next;
}

// functions
void removeEveryOther (ListType &list) {
    Node *curr = list;
    // Condition for list size 0 and 1
    if (curr == nullptr || curr->next == nullptr) {
        return;
    }
    // For all list size > 1
    while (curr->next != nullptr) {
        Node *temp = curr->next;
        curr->next = curr->next->next;
        delete temp;
        curr = curr->next;
        // break if curr is nullptr
        if (curr == nullptr) {
            break;
        }
    }
}

ListType buildList (ListType &list, vector<int> vec) {
    // Deallocte memory for existing list
    while (list != nullptr) {
        Node *temp = list;
        list = list->next;
        delete temp;
    }

    // Build new list
    for (int i = (signed)vec.size() - 1; i >= 0; i--) {
        list = new Node(vec[i], list);
    }
    return list;
}

void printList (ListType list) {
    cout << "( ";
    Node *curr = list;
    while (curr != nullptr) {
        cout << curr->data; 
        if (curr->next != nullptr) {
            cout << " ";
        }
        curr = curr->next;
    }
    cout << " )" << endl;
}

int main () {
    ListType list = nullptr;
    vector<int> vec;

    // Test 1: Even number nodes
    vec = {3, 5, 7, 9};
    list = buildList(list, vec);
    printList(list);
    removeEveryOther(list);
    printList(list);

    // Test 2: Odd number nodes
    vec = {2, 7, 2};
    list = buildList(list, vec);
    printList(list);
    removeEveryOther(list);
    printList(list);

    // Test 3: Single node
    vec = {12};
    list = buildList(list, vec);
    printList(list);
    removeEveryOther(list);
    printList(list);

    // Test 4: Remove multiple nodes odd
    vec = {10, 8, 6, 4, 2};
    list = buildList(list, vec);
    printList(list);
    removeEveryOther(list);
    printList(list);

    // Test 5: Empty list
    vec = {};
    list = buildList(list, vec);
    printList(list);
    removeEveryOther(list);
    printList(list);
    
    return 0;
}