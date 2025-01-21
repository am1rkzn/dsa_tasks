// Amir Valeev CSE-06
#include <iostream>

using namespace std;


void sorting(int arr[], int n) { // bubble sorting
    bool changed = true;
    while (changed) {
        changed = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr[i], arr[i + 1]);
                changed = true;
            }
        }
    }
}
void fillingArray(int arr[], int n) { // filling array with input data
    for ( int i = 0; i < n; i++ ) {
        cin >> arr[i];
    }
}
void printArray(int arr[],int n) { // printing array
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
}
int main() {
    int n_members;
    cin >> n_members;
    int arr[n_members];
    fillingArray(arr, n_members);
    sorting(arr, n_members);
    printArray(arr, n_members);
}
