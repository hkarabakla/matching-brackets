# matching-brackets

Algorithm:

* Declare a character stack S.
* Now traverse the expression string exp.
   1. If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
   2. If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
* After complete traversal, if there is some starting bracket left in stack then “not balanced”
