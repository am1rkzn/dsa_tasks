// Amir Valeev CSE-06
#include <iostream>

using namespace std;
void fillingArray(string n_part[], int score[], int n) { // filling array with input data
    for (int i = 0; i < n; i++) {
        cin >> n_part[i] >> score[i];
    }
}
void sorting(string n_part[], int score[], int n) { // reversed bubble sort
    bool changed = true;
    while (changed) {
        changed = false;
        for (int i = 0; i < n - 1; i++) {
            if (score[i] < score[i + 1]) {
                swap(score[i], score[i + 1]);
                swap(n_part[i], n_part[i + 1]);
                changed = true;
            }
        }
    }
}
void printingResult(string n_part[], int score[], int place) { // printing result
    for (int i = 0; i < place; i++) {
        cout << n_part[i] << " " << score[i] << endl;
    }
}
int main() {
    int n_participants;
    int place_participant;
    cin >> n_participants >> place_participant;
    string name_participants[n_participants];
    int participants_score[n_participants];
    fillingArray(name_participants, participants_score, n_participants);
    sorting(name_participants, participants_score, n_participants);
    printingResult(name_participants, participants_score, place_participant);
}
