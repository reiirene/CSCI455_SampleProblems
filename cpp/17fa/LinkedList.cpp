// Hsin Li
// 05/04/2024
// Problem 8 of Fall 2017 Exam
// Description: LinkedList, parameter passing

#include <iostream>

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
// insertFront: inserts a new node with value val at the front of the list
/*
// Original (Incorrect)
void insertFront(ListType list, int val) {
    list = new Node(val, list);
}
*/
// Corrected
void insertFront(ListType &list, int val) {
    list = new Node(val, list);
}

// printList: prints list using the format: (3 5 4 7)
// prints an empty list as: () 
// PRE: list is a well-formed list 
void printList(ListType list) {
    while (list != nullptr) {
        cout << list->data << " ";
        list = list->next;
    }
    cout << endl;
}

// main function
int main() {
    ListType myList = new Node(1);
    myList->next = new Node(2);
    Node *p = myList->next;
    p->next = new Node(3);

    printList(myList);
    insertFront(myList, 57);
    printList(myList);
}