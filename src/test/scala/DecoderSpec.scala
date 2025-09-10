import org.scalatest.flatspec.AnyFlatSpec

class DecoderSpec extends AnyFlatSpec {

  "Decoder" should "decode a simple string correctly" in {
    val input: String = "5G"
    val expected: String = "GGGGG"
    assert(Decoder.recursiveDecode(input) == expected)
  }

  it should "decode a string with multiple digits correctly" in {
    val input: String = "3ABC"
    val expected: String = "ABCABCABC"
    assert(Decoder.recursiveDecode(input) == expected)
  }

  it should "decode a nested string correctly" in {
    val input: String = "2X(3Y(2Z))"
    val expected: String = "XYZZYZZYZZXYZZYZZYZZ"
    assert(Decoder.recursiveDecode(input) == expected)
    assert(Decoder.recursiveDecode("3A(2BC)") == "ABCBCABCBCABCBC")
  }

  it should "decode a string where the number is more than one digit" in {
    val input: String = "12A(3Y)"
    val expected: String = "AYYY" * 12
    assert(Decoder.recursiveDecode(input) == expected)
  }

}
