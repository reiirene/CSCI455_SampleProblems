// Hsin Li
// 05/04/2024
// Problem 10 of Spring 2023 Exam
// Description: Cstring

#include <iostream>
#include <cstring>

using namespace std;

// computes length of array necessary to store a C string version of a sentence
// containing all the words in an array of C strings called words.
int totalLength (const char *words[], int numWords) {
    int totalLength = 0;
    for (int i = 0; i < numWords; i++) {
        totalLength += strlen(words[i]);
    }
    return totalLength + numWords + 1;  // add numWords for spaces and the period at the end
                                        // +1 to account for NULL terminator
}

// returns a dynamic C string made up of the words in words array, space
// separated, and ending with a period.  A few examples of its use: 
//    words                     numWords     makeSentence(words, numWords)
//    ["the", "big", "dog"]     3            "the big dog."
//    ["Hello"]                 1            "Hello."
// PRE: words is an array of numWords valid C strings and numWords >= 1  
char * makeSentence (const char *words[], int numWords) {
    int length = totalLength(words, numWords);  // example use of totalLength
    char *sentence = new char[length + 1];
    sentence[0] = '\0';
    // populate sentence with words in words[]
    for (int i = 0; i < numWords; i++) {
        strcat(sentence, words[i]);
        if (i != numWords - 1) {
            strcat(sentence, " ");
        }
    }
    strcat(sentence, ".");
    return sentence;
}

int main () {
    // Test 1
    // the big dog.
    const char *words1[] = {"the", "big", "dog"};
    int numWords1 = 3;

    char *result1 = makeSentence(words1, numWords1);
    cout << result1 << endl;

    delete[] result1;

    // Test 2
    // Hello.
    const char *words2[] = {"Hello"};
    int numWords2 = 1;

    char *result2 = makeSentence(words2, numWords2);
    cout << result2 << endl;

    delete[] result2;
    return 0;
}