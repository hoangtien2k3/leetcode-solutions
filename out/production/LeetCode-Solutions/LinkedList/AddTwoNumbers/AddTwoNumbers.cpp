/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class ListNode {
    int val;
    ListNode *next;
    ListNode() {
    }
    ListNode(int val) {
        this->val = val;
    }
    ListNode(int val, ListNode next) {
        this->val = val;
        this->next = next;
    }
};


class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * dummy = new ListNode();
        ListNode * current = dummy;

        int carry = 0;
        while(l1 != NULL || l2 != NULL) {
            int l1_val = (l1 != NULL) ? l1->val : 0;
            int l2_val = (l2 != NULL) ? l2->val : 0;

            int sum = l1_val + l2_val + carry;
            carry = sum / 10;
            int last_digit = sum % 10;

            ListNode * new_node = new ListNode(last_digit);
            current->next = new_node;

            if (l1 != NULL) l1 = l1->next;
            if (l2 != NULL) l2 = l2->next;
            current = current->next;
        }

        if (carry > 0) {
            ListNode * newNode = new ListNode(carry);
            current->next = newNode;
            current = current->next;
        }
        return dummy->next;
    }
};

int main() {}

