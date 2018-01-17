/*
ID: arnavmohan
LANG: C++11
TASK: xxxxxx
*/

#include <fstream>
#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>
#include <assert.h>

using namespace std;

typedef vector<int> int_vec_t;
typedef vector<bool> bool_vec_t;
typedef vector<int_vec_t> int_2dvec_t;
typedef vector<bool_vec_t> bool_2dvec_t;

const string prog ("homework");
string ifname (prog + ".in");
string ofname (prog + ".out");
istream *ifp;
ostream *ofp;

#define MAX_N 100000

int n;

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

    int_vec_t scores;
    scores.resize(n);
    for(int i = 0; i < n; i++){
        *ifp >> scores[i];
    }
    
    double max = 0;
    int min = 10001;
    int_vec_t c;
    c.push_back(scores[n-1]);
    int sum = scores[n-1];
    int_vec_t kfin;
    for(int k = n-2; k > 0; k--){
        int sk = scores[k];
        sum = sum + sk;
        if(sk < min){
            min = sk;
        }
        else{
            c.push_back(sk);
            c.erase(remove(c.begin(), c.end(), min), c.end());
        }
        int tsum = sum - min;
        double score = (double)tsum / (double)(c.size());
        if(score > max){
            max = score;
            kfin.clear();
            kfin.push_back(k);
        }
        if(score == max && kfin[0] != k){
            kfin.push_back(k);
        }
        c.insert(c.begin(),min);
    }
    
    sort(kfin.begin(), kfin.end());
    for(int i = 0; i < kfin.size(); i++){
        *ofp << kfin.at(i) << '\n';
    }

    //complete if necessary. if completed elsehwere, this line will just be redundant
    complete();
  
}
