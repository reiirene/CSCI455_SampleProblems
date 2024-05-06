// Hsin Li
// 05/04/2024
// Problem 8 of Fall 2023 Exam
// Description: Box-and-pointer diagram for buggy removeLast function

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

// PRE: list is a well-formed list
void removeLast(ListType &list) {
    if (list == nullptr) {
        return;
    }

    if (list->next == nullptr) {
        delete list;
        list = nullptr;
        return;
    }

    while (list->next->next != nullptr) {
        list = list->next;
    }

    delete list->next;
    list->next = nullptr;
}

// printList: prints list using the format: (3 5 4 7)
// prints an empty list as: ()
// PRE: list is a well-formed list
void printList(ListType list) {
    cout << "(";
    while (list != nullptr) {
        cout << list->data;
        list = list->next;
        if (list != nullptr) {
            cout << " ";
        }
    }
    cout << ")" << endl;
}

int main () {
    ListType myList = new Node(1);
    myList->next = new Node(2);
    Node *p = myList->next;
    p->next = new Node(3);

    printList(myList);
    removeLast(myList);
    printList(myList);
}
