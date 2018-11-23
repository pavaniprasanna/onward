/*
* Fast palindrome number detection
*
* @author pavaniprasanna
* 11/22/2018
*/

#include <iostream>

// optimize int for speed
static int x = [](){
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    return NULL;
}();

class Solution {
public:
    bool isPalindrome(int x) {

    // return 0 for obvious non palindromes
    if (x < 0 || (x%10 == 0 && x != 0)) return 0;

    int rev = 0;
    int tx = x;

    // compute reverse
    while (tx > 0) {
      rev = rev*10 + tx%10;
      tx = tx/10;
    }

    // check if reverse matches with original
    return x == rev;
    }
};


int main(int argc, char** arg) {
      printf("palindrome? %d", Solution().isPalindrome(123));
}
