#include <vector>
using namespace std;

class Solution {
public:
    bool isTrionic(vector<int>& seq) {
        int n = seq.size();
        for (int mid = 1; mid < n - 2; ++mid) {
            if (seq[mid - 1] < seq[mid] && seq[mid] > seq[mid + 1]) {
                int l = mid - 1;
                while (l > 0 && seq[l - 1] < seq[l]) --l;
                if (l != 0) continue;
                int r = mid + 1;
                while (r + 1 < n && seq[r] > seq[r + 1]) ++r;
                if (r + 1 >= n || seq[r] >= seq[r + 1]) continue;
                while (r + 1 < n && seq[r] < seq[r + 1]) ++r;
                if (r == n - 1) return true;
            }
        }
        return false;
    }
};
