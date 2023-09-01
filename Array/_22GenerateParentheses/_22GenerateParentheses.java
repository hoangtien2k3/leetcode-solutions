package Array._22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
            Sơ đồ Đệ Quy (Recursion Tree): n = 3

    	                                             (0, 0, '')
								 	                    |
									                (1, 0, '(')
								          /                            \
						  (2, 0, '((')                                    (1, 1, '()')
					   /               \                                              \
				(3, 0, '(((')       (2, 1, '(()')                                 (2, 1, '()(')
					/                   /       \                                /              \
			(3, 1, '((()')   (3, 1, '(()(')   (2, 1, '(()')               (3, 1, '()((')     (2, 2, '()()')
				/                    /             \                           /                   \
	    (3, 1, '((()')    (3, 2, '(()()')      (2, 2, '(())')           (3, 2, '()(()')         (3, 2, '()()(')
			/                    /                   \                       /                       \
	(3, 2, '((())')    (3, 3, '(()())')          (3, 2, '(())(')      (3, 3, '()(())')          (3, 3, '()()()')
		 /                     |                       \                     |                         |
  (3, 3, '((()))')     res.append('(()())')       (3, 3, '(())()')    res.append('()(())')      res.append('()(())')
	    |                                               |
 res.append('((()))')                            res.append('(())()')

*/
class Solution {
    public void recursionParenthesis(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) { // vì số ngoặc sẽ gấp đôi.
            res.add(s);
            return;
        }
        if (left < n) {
            recursionParenthesis(res, left + 1, right, s + "(", n);
        }
        if (right < left) {
            recursionParenthesis(res, left, right + 1, s + ")", n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursionParenthesis(res, 0, 0, "", n);
        return res;
    }
}

public class _22GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(n);
        for(String str : list) {
            System.out.println(str);
        }
    }
}
