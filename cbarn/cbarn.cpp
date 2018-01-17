/*
ID: arnavmohan
LANG: C++11
TASK: cbarn
*/

#include <fstream>
#include <iostream>
#include <limits>
#include <string>
#include <cmath>
#include <vector>
#include <assert.h>

using namespace std;

typedef vector<int> int_vec_t;
typedef vector<bool> bool_vec_t;
typedef vector<int_vec_t> int_2dvec_t;
typedef vector<bool_vec_t> bool_2dvec_t;

const string prog ("cbarn");
string ifname (prog + ".in");
string ofname (prog + ".out");
istream *ifp;
ostream *ofp;

#define MAX_N 3500

int N;

void complete(){

    //do any final output to ile if needed
    //*ofp << endl;

    delete ofp;
    delete ifp;
    exit(0);
}

int* rotate(int a[], int l){
    int* res = new int[N*sizeof(int)];
    copy(a, a + N, res);
    for(int i = 0; i < l; i++) {
        for(int j = N - 1; j > 0; j--){
            int temp = res[j];
            res[j] = res[j-1];
            res[j-1] = temp;
        }
    }
    return res;
}


int main() {
    ifp = new ifstream(ifname);

    ofp = new ofstream(ofname);
  
    

    *ofp << lowest << endl;

    //complete if necessary. if completed elsehwere, this line will just be redundant
    complete();
  
}
