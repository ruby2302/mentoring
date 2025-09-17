import scala.annotation.tailrec
/*
You are given an encoded string containing letters, digits, and parentheses. Your task is to decode the string according to the following rules:
A number followed by a letter (e.g., 5G) means repeat the letter that many times.
Example: 5G -> GGGGG
2. A number followed by a sequence of letters (e.g., 3ABC) means repeat the entire sequence that many times.
       Example: 3ABC -> ABCABCABC
3. Parentheses are solely used to group sequences, and grouping can be nested. You must always expand innermost parentheses first.
Example: 3A(2BC) -> [expand 2BC] -> 3ABCBC -> ABCBCABCBCABCBC

Write a function in Scala using a functional programming style.
Input Constraints:
The encoded input string is guaranteed to be valid
Numbers are positive integers.
There will be no whitespace.
Maximum nesting depth: reasonable for recursion or stack use.

Examples
| Input | Output |
|---------------|----------------------|
| 4A | AAAA |
| 2AB | ABAB |
| 3A(2BC) | ABCBCABCBCABCBC |
| 2X(3Y(2Z)) | XYZZYZZYZZXYZZYZZYZZ |

Bonus (Optional):
Handle cases where the number is more than one digit (e.g., 12A -> AAAAAAAAAAAA).
 */

object Decoder {

  @tailrec
  def recursiveDecode(inputString: String): String = {

    def decode(encoded: String): String = {
      val multiplier = encoded.filter(_.isDigit).toInt
      val pattern = encoded.filter(_.isLetter)
      pattern * multiplier
    }

    if (!inputString.contains('(')) decode(inputString)
    else {
      // find innermost pattern
      val (prefix, innermost) = inputString.splitAt(inputString.lastIndexOf('('))
      recursiveDecode(prefix + decode(innermost))
    }
  }
}
