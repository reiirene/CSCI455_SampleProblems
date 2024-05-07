// Hsin Li
// 05/04/2024
// Problem 9 of Spring 2023 Exam
// Description: Pointers

#include <iostream>
#include <string>

using namespace std;

class Student {
public:
    // create a student with the specified name and a score of 0
    Student (const std::string &name) {
        theName = name;
        score = 0;
    }

    void setScore (int aScore) {
        score = aScore;
    }

    int getScore() const {
        return score;
    }

    std::string getName() const {
        return theName;
    }
private:
    std::string theName;
    int score;
};

int main () {
    Student *p = new Student("Zhou");
    Student *r = new Student("Sam");

    p->setScore(25);    // p -> {"Zhou", 25}

    r->setScore(50);    // r -> {"Sam", 50}

    string name = r->getName(); // name = "Sam"

    name += "my";   // appends to the string name (C++ strings are mutable)
                    // name = "Sammy"
    cout << r->getName() << endl;   // Sam

    *r = *p;    // p -> {"Zhou", 25}
                // r -> {"Zhou", 25}

    cout << p->getScore() << endl;  // 25
    cout << r->getScore() << endl;  // 25

    r->setScore(0);    // p -> {"Zhou", 25}
                       // r -> {"Zhou", 0}

    cout << p->getScore() << endl;  // 25
    cout << r->getScore() << endl;  // 0

    r = p;    // p -> {"Zhou", 25}
              // r ---↑

    cout << p->getScore() << endl;  // 25
    cout << r->getScore() << endl;  // 25

    r->setScore(30);    // p -> {"Zhou", 30}
                        // r ---↑

    
    cout << p->getScore() << endl;  // 30
    cout << r->getScore() << endl;  // 30

    return 0;
}