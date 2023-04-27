#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> getPossibleWindowDimensions(int size)
{
    vector<pair<int, int>> dimensions;
    for (int i = 1; i <= size; i++)
    {
        if (size % i == 0)
        {
            dimensions.push_back(make_pair(i, size / i));
        }
    }
    return dimensions;
}

bool checkIfSubarrContainsAll(vector<vector<int>> grid, vector<string> colors, int x, int y, int x2, int y2)
{
    for (string color : colors)
    {
        int colorIndex = find(colors.begin(), colors.end(), color) - colors.begin() + 1;
        vector<int> subArr;

        for (int i = x; i <= x2; i++)
        {
            for (int j = y; j <= y2; j++)
            {
                int index = grid[i][j];

                if (find(subArr.begin(), subArr.end(), index) == subArr.end())
                {
                    subArr.push_back(index);
                }
            }
        }

        if (find(subArr.begin(), subArr.end(), colorIndex) == subArr.end())
        {
            return false;
        }
    }

    return true;
}

int main()
{
    ifstream inp("input.txt");
    ofstream out("output.txt");
    int T;
    inp >> T;

    for (int t = 0; t < T; t++)
    {
        int N, C, Q;
        inp >> N >> C >> Q;
        vector<vector<int>> grid(N, vector<int>(N, 0));
        vector<string> colors;

        for (int q = 0; q < Q; q++)
        {
            int x, y;
            string color;
            inp >> x >> y >> color;
            if (find(colors.begin(), colors.end(), color) == colors.end())
            {
                colors.push_back(color);
            }
            int colorIndex = find(colors.begin(), colors.end(), color) - colors.begin() + 1;
            grid[x][y] = colorIndex;
        }

        int size = colors.size();
        bool done = false;
        while (!done)
        {
            vector<pair<int, int>> dimensions = getPossibleWindowDimensions(size);

            for (pair<int, int> dimension : dimensions)
            {
                int w = dimension.first;
                int h = dimension.second;

                for (int x = 0; x <= N - w; x++)
                {
                    for (int y = 0; y <= N - h; y++)
                    {
                        int x2 = x + w - 1;
                        int y2 = y + h - 1;

                        if (checkIfSubarrContainsAll(grid, colors, x, y, x2, y2))
                        {
                            int subArrSize = w * h;
                            string output = "Case #" + to_string(t + 1) + ": " + to_string(x) + " " + to_string(y) +
                                            " " + to_string(x2) + " " + to_string(y2) + " " + to_string(subArrSize);
                            cout << output << endl;
                            out << output << endl;
                            done = true;
                            break;
                        }
                    }
                    if (done)
                    {
                        break;
                    }
                }
                if (done)
                {
                    break;
                }
            }

            if (done)
            {
                break;
            }

            size++;
        }
    }

    inp.close();
    out.close();
    return 0;
}