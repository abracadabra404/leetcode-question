```java
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                builder.append(ch);
            }
        }
        // 一左一右两个指针相向而行
        int left = 0,right = builder.length() -1;
        while (left < right) {
            if (Character.toLowerCase(builder.charAt(left++)) != Character.toLowerCase(builder.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}
```