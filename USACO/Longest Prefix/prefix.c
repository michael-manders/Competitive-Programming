#include <stdio.h>
#include <string.h>

int main() {
    FILE *inp = fopen("prefix.in", "r");
    FILE *out = fopen("prefix.out", "w");

    char prefixes[200][11], seq[200001];
    int prefix_count = 0, i, j;
    bool seqStart = false;

    while(fscanf(inp, "%s", prefixes[prefix_count]) && strcmp(prefixes[prefix_count], ".") != 0) {
        prefix_count++;
    }

    while(fscanf(inp, "%s", seq) != EOF) {
        strcat(seq, seq);
    }
    int n = strlen(seq);

    bool dp[n][prefix_count];

    memset(dp, 0, sizeof dp);

    for (i = n - 1; i >= 0; --i) {
        for (j = 0; j < prefix_count; ++j) {
            if (seq[i] == prefixes[j][0] && strncmp(&seq[i], prefixes[j],strlen(prefixes[j])) == 0 ) {
                if(i+strlen(prefixes[j]) == n)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i+strlen(prefixes[j])][0];
            }
        }
     }

    int ans = 0;
    for (i = 0; i < n; ++i) {
        if (dp[i][0]) {
            ans = i + 1;
            for (j = 1; j < prefix_count; ++j) {
                if (dp[i][j]) break;
            }
            if (j == prefix_count) continue;
            for (j = i+1; j <= ans && j < n; ++j) {
                if (!dp[j][0]) continue;
                dp[j][0] = false;
                for (int k = 1; k < prefix_count; ++k) {
                    if (!dp[j][k]) continue;
                    if (j+strlen(prefixes[k]) == n) {
                        fprintf(out, "%d\n", n);
                        exit(0);
                    }
                    dp[j+strlen(prefixes[k])][k] = true;
                    if (dp[j+strlen(prefixes[k])][0]) 
                        ans = j + strlen(prefixes[k]);
                }
             }
        }
    }

    fprintf(out, "%d\n", ans);

    fclose(inp);
    fclose(out);
    return 0;
}
