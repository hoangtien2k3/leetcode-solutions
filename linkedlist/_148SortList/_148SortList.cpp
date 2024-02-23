#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
            return head;

        // Find middle node
        ListNode* prev = nullptr;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        if (prev != nullptr)
            prev->next = nullptr; // Splitting the list

        // Recursively sort two halves
        ListNode* left = sortList(head);
        ListNode* right = sortList(slow);

        // Merge the sorted halves
        return merge(left, right);
    }

    // merge single linked list
    ListNode* merge(ListNode* left, ListNode* right) {
        ListNode* dummy = new ListNode(0);
        ListNode* current = dummy;

        while (left != nullptr && right != nullptr) {
            if (left->val < right->val) {
                current->next = left;
                left = left->next;
            } else {
                current->next = right;
                right = right->next;
            }
            current = current->next;
        }

        if (left != nullptr)
            current->next = left;
        else if (right != nullptr)
            current->next = right;

        return dummy->next;
    }
};

int main() {
    // Tạo một danh sách liên kết để kiểm tra
    ListNode* head = new ListNode(3);
    head->next = new ListNode(2);
    head->next->next = new ListNode(4);
    head->next->next->next = new ListNode(1);

    // Sử dụng lớp Solution để sắp xếp danh sách liên kết
    Solution solution;
    ListNode* sortedList = solution.sortList(head);

    // In ra danh sách liên kết đã sắp xếp
    std::cout << "Sorted List: ";
    while(sortedList !=   nullptr) {
        std::cout << sortedList->val << " ";
        sortedList = sortedList->next;
    }
    std::cout << std::endl;

    return 0;
}