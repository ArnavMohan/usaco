/*
ID: arnavmohan
LANG: C++11
TASK: shuffle
*/

#include <fstream>
#include <iostream>
#include <string>
#include <cmath>
#include <queue>
#include <vector>
#include <assert.h>

using namespace std;

typedef vector<int> int_vec_t;
typedef vector<bool> bool_vec_t;
typedef vector<int_vec_t> int_2dvec_t;
typedef vector<bool_vec_t> bool_2dvec_t;

const string prog ("shuffle");
string ifname (prog + ".in");
string ofname (prog + ".out");
istream *ifp;
ostream *ofp;

#define MAX_N 100000

int n;
int* numin;
int* shuffle;

void complete(){

    //do any final output to ile if needed
    //*ofp << endl;

    delete ofp;
    delete ifp;
    exit(0);
}

int main() {
    ifp = new ifstream(ifname);

    ofp = new ofstream(ofname);
  
    //file input
    *ifp >> n;
    shuffle = new int[n];
    numin = new int[n];

    for(int i = 0; i < n; i++){
        *ifp >> shuffle[i];
        shuffle[i]--;
        numin[shuffle[i]]++;
    }
    int rem = n;
    queue<int> q;
    for(int i = 0; i < n; i++){
        if(numin[i] == 0){
            q.push(i);
            rem--;
        }
    }
    while(!q.empty()){
        int node = q.front();
        numin[shuffle[node]]--;
        if(numin[shuffle[node]] == 0){
            q.push(shuffle[node]);
            rem--;
        }
        q.pop();
    }
        
    *ofp << rem << endl; 
    
    //complete if necessary. if completed elsehwere, this line will just be redundant
    complete();
  
}
