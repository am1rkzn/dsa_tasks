// Amir Valeev CSE-06
#include <iostream>
#include <vector>
using namespace std;
// heapifying function
// I use reference to automatically change the array (vector) during heapifying
// i is index of parent element in the array for comparing with children
void max_heapify(vector<int>& vec, int i, int d, int heapSize) {
    int largest = i;
    // we need to compare the range of d elements
    for (int k = 1; k <= d; k++){
        //the index of children. vectors and arrays start from 0 index. 
        // that's why my pseudocode from problem set has been modified
        int child = (d * i) + k;
        if (child < heapSize && vec[child] > vec[largest]){
            largest = child;
        }
    }
    // if some of the children is greater than parent
    if (largest != i){
        swap(vec[i], vec[largest]);
        max_heapify(vec, largest, d,heapSize);
    }
}
// building max heap
void build_max_heap(vector<int>& vec, int d){
    int heap_size = vec.size();
    // we need to set the index of the element from which we will start heapifying
    int start = (heap_size-1) / 2;
    for (int i = start; i >= 0; i--){
        max_heapify(vec,i,d,heap_size);
    }
}

int main(){
    int N,d;
    cin >> N >> d;
    vector<int> vec(N);
    for (int i = 0; i < N; i++){
        cin >> vec[i];
    }
    build_max_heap(vec, d);
    for(int i: vec){
        cout << i << " ";
    }
}
