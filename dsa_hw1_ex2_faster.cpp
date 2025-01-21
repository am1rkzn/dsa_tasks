// Amir Valeev CSE-06
#include <iostream>

using namespace std;
void fillingArray(string n_part[], int score[], int n) { // filling array with the input data
    for (int i = 0; i < n; i++) {
        cin >> n_part[i] >> score[i];
    }
}
void sorting(int score[], int n_part, string name[], int place){
    // sorting with the reverse selection sort array "place" times. this method will take less time
    int count = 0;
    for (int i = 0; i < n_part - 1; i++){
        int max = i;
        for (int j = i + 1; j < n_part; j++){
            if (score[j] > score[max]){
                max = j;
            }
        }
        swap(score[i], score[max]);
        swap(name[max], name[i]);
        count++;
        if (count == place) { 
            break;
        }
    }
}
void printingResult(string name[], int score[], int place) { // printing result
    for (int i = 0; i < place; i++) {
        cout << name[i] << " " << score[i] << endl; 
    }
}
int main() {
    int n_participants;
    int place_participant;
    cin >> n_participants >> place_participant;
    string name_participants[n_participants];
    int participants_score[n_participants];
    fillingArray(name_participants, participants_score, n_participants);
    sorting(participants_score, n_participants, name_participants, place_participant);
    printingResult(name_participants, participants_score, place_participant);
}
