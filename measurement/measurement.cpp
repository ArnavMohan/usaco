/*
ID: arnavmohan
LANG: C++11
TASK: measurement
*/

#include <fstream>
#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <assert.h>
#include <set>
#include <map>

using namespace std;

typedef vector<int> int_vec_t;
typedef vector<bool> bool_vec_t;
typedef vector<int_vec_t> int_2dvec_t;
typedef vector<bool_vec_t> bool_2dvec_t;

const string prog ("measurement");
string ifname (prog + ".in");
string ofname (prog + ".out");
istream *ifp;
ostream *ofp;

#define MAX_N 3500

int n;
int g;

struct measurement{
    int day;
    int id;
    int change;
};


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
    *ifp >> g;
    vector<measurement> meas;
    meas.resize(n);
    for(int i = 0; i < n; i++){
        *ifp >> meas[i].day >> meas[i].id >> meas[i].change;
    }
    sort(meas.begin(), meas.end(), [](const measurement& a, const measurement& b){
        return a.day < b.day; });
    map <int, int, greater<int>> counts;
    counts[0] = n+1;
    int changes = 0;
    map <int, int> cows;
    for(int i = 0; i < n; i++){
        measurement m = meas[i];
        bool top = (cows[m.id] == counts.begin()->first);
        int count = counts[cows[m.id]];
        counts[cows[m.id]]--;
        if(count == 1){
            counts.erase(cows[m.id]);
        }
        cows[m.id]+=m.change;
        int currcount = ++counts[cows[m.id]];
        bool currtop = (cows[m.id] == counts.begin()->first);
        if((top && (!currtop || count != 1 || currcount != 1)) || (!top && currtop)){
            changes++;
        }
    }

    *ofp << changes << endl;
  
    //complete if necessary. if completed elsehwere, this line will just be redundant
    complete();
  
}
