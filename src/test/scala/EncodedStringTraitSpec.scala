import org.scalatest.flatspec.AnyFlatSpec

class EncodedStringTraitSpec extends AnyFlatSpec {

  "EncodedStringTrait" should "decode a simple string correctly" in {
    val input = "5G"
    val expected = "GGGGG"
    val actual = EncodedStringTrait.parse(input).decode
    println(s"Decoded string: $actual")
    assert(actual == expected)
  }

  it should "decode a string with multiple digits correctly" in {
    val input = "3ABC"
    val expected = "ABCABCABC"
    val actual = EncodedStringTrait.parse(input).decode
    println(s"Decoded string: $actual")
    assert(actual == expected)
  }

  it should "decode a nested string correctly" in {
    val input = "2X(3Y(2Z))"
    val expected = "XYZZYZZYZZXYZZYZZYZZ"
    val actual = EncodedStringTrait.parse(input).decode
    println(s"Decoded string: $actual")
    assert(actual == expected)
    assert(EncodedStringTrait.parse("3A(2BC)").decode == "ABCBCABCBCABCBC")
  }

  it should "decode a string where the number is more than one digit" in {
    val input = "12A(3Y)"
    val expected = "AYYY" * 12
    assert(EncodedStringTrait.parse(input).decode == expected)
  }





}
