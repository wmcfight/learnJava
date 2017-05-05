package leetcode;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

public boolean isPalindrome(String s) {
		boolean result = true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if ((Character.isLetter(s.charAt(i))
					&& Character.isLetter(s.charAt(j)) && (Character
					.toLowerCase(s.charAt(i)) == Character.toLowerCase(s
					.charAt(j))))
					|| (Character.isDigit(s.charAt(i))
							&& Character.isDigit(s.charAt(j)) && (s.charAt(i) == s
							.charAt(j)))) {
				i++;j--;
			}else{
				result = false;
				break;
			}

		}
		return result;

	}
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean result = true;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if ((Character.isLetter(s.charAt(i))
                    && Character.isLetter(s.charAt(j)) && (Character
                    .toLowerCase(s.charAt(i)) == Character.toLowerCase(s
                    .charAt(j))))
                    || (Character.isDigit(s.charAt(i))
                    && Character.isDigit(s.charAt(j)) && (s.charAt(i) == s
                    .charAt(j)))) {
                i++;j--;
            }else{
                result = false;
                break;
            }

        }
        return result;
    }
}
