#include <vector>
using namespace std;

class Solution {
public:
    int maxBalancedShipments(vector<int>& load) {
        int total = 0, n = load.size(), begin = 0;
        while (begin < n - 1) {
            int peak = load[begin], cut = -1;
            for (int i = begin + 1; i < n; ++i) {
                if (load[i] > peak) peak = load[i];
                if (load[i] < peak) cut = i;
                if (cut != -1) {
                    total++;
                    begin = cut + 1;
                    break;
                }
            }
            if (cut == -1) break;
        }
        return total;
    }
};
