#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

bool isPrimeNum(int num){
    if(num <= 1) return false;
    if(num <= 3) return true;
    if(num % 2 == 0) return false;
    for(int div = 3; div <= sqrt(num); div += 2){
        if(num % div == 0) return false;
    }
    return true;
}

int go(vector<int> &nums, int depth, int start, int sum){
    if(depth == 3){
        if(isPrimeNum(sum)) return 1;
        else return 0;
    }
    int cnt = 0;
    for(int i = start ; i < nums.size(); i++){
        cnt += go(nums, depth + 1, i + 1, sum + nums[i]);
    }
    return cnt;
}


int solution(vector<int> nums) {
    return go(nums, 0, 0, 0);
}