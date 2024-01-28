#include <bits/stdc++.h>
using namespace std;


int main() {

  int n;
  cin >> n;
  int notes[n];
  for(int i = 0; i < n; i++) cin >> notes[i];

  n--;
  int dist[n];
  for (int i = 0; i < n; i++) {
    dist[i] = notes[i+1] - notes[i];
  }
  
  int ans = 0;
  for(int i = 5; i < n; i++) {
    int fplen = 0;
    int fnlen = 0;
    int bplen = 0;
    int bnlen = 0;
    for(int j = 0; j < i; j++) {
      if(i+fplen < n && dist[i+fplen] == dist[j]) {
        fplen++;
      }
      else {
        if(fplen>=4) ans = max(ans,fplen);
        fplen = 0;
      }
      
      if(i+fnlen < n && dist[i+fnlen] == -dist[j]) {
        fnlen++;
      }
      else {
        if(fnlen>=4) ans = max(ans,fnlen);
        fnlen = 0;
      }

      if(i - bplen > j && dist[i-bplen] == dist[j]) {
        bplen++;
      }
      else {
        if(bplen>=4) ans = max(ans,bplen);
        bplen = 0;
      }

      if(i - bnlen > j && dist[i-bnlen] == -dist[j]) {
        bnlen++;
      }
      else{
        if(bnlen>=4) ans = max(ans,bnlen);
        bnlen = 0;
      }
    }
  }

  if (ans == 0) {
    cout << 0;
  }
  else {
    cout << ans + 1;
  }

  return 0;
}