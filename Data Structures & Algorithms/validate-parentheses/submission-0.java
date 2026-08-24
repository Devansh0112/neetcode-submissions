class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> hmap = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for (char c: s.toCharArray()) {
            if (hmap.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != hmap.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        

        return stack.isEmpty();
    }
}
