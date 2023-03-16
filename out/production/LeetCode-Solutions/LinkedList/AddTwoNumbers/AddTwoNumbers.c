#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *dummy = (struct ListNode *)malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = NULL;
    struct ListNode *cur = dummy;
    int carry = 0;

    while (l1 || l2) {
        int x = l1 ? l1->val : 0;
        int y = l2 ? l2->val : 0;
        int sum = x + y + carry;
        carry = sum / 10;
        cur->next = (struct ListNode *)malloc(sizeof(struct ListNode));
        cur = cur->next;
        cur->val = sum % 10;
        cur->next = NULL;

        if (l1) l1 = l1->next;
        if (l2) l2 = l2->next;
    }

    if (carry) {
        cur->next = (struct ListNode *)malloc(sizeof(struct ListNode));
        cur = cur->next;
        cur->val = carry;
        cur->next = NULL;
    }

    return dummy->next;
}

int main() {
    // Tạo danh sách liên kết l1 = 2 -> 4 -> 3
    struct ListNode *l1 = (struct ListNode *)malloc(sizeof(struct ListNode));
    l1->val = 2;
    l1->next = (struct ListNode *)malloc(sizeof(struct ListNode));
    l1->next->val = 4;
    l1->next->next = (struct ListNode *)malloc(sizeof(struct ListNode));
    l1->next->next->val = 3;
    l1->next->next->next = NULL;

    // Tạo danh sách liên kết l2 = 5 -> 6 -> 4
    struct ListNode *l2 = (struct ListNode *)malloc(sizeof(struct ListNode));
    l2->val = 5;
    l2->next = (struct ListNode *)malloc(sizeof(struct ListNode));
    l2->next->val = 6;
    l2->next->next = (struct ListNode *)malloc(sizeof(struct ListNode));
    l2->next->next->val = 4;
    l2->next->next->next = NULL;

    // Tính tổng của hai danh sách liên kết và in kết quả
    struct ListNode *sum = addTwoNumbers(l1, l2);
    while (sum) {
        printf("%d", sum->val);
        if (sum->next) printf(" -> ");
        sum = sum->next;
    }
    printf("\n");

    return 0;
}

