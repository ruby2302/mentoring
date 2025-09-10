import scala.annotation.tailrec


trait EncodedStringTrait {
  def decode: String
}

object EncodedStringTrait {

   def parse(input:String): EncodedStringTrait =
    if (!input.contains('(')) {
      SimpleEncodedString(input)
    } else {
      ComplexEncodedString(input)
    }
}

case class SimpleEncodedString(numberOfRepetitions: Int, stringPattern: String) extends EncodedStringTrait {
  override def decode: String = stringPattern * numberOfRepetitions
}

case object SimpleEncodedString {

  def apply(input: String): SimpleEncodedString = {
    val numberOfRepetitions = input.filter(_.isDigit).toInt
    val stringPattern = input.filter(_.isLetter)
    SimpleEncodedString(numberOfRepetitions, stringPattern)
  }
}
// Is there a way you can avoid recreating the simpleEncodedString instances and make this more efficient?
// Could we use recursion here?
case class ComplexEncodedString(encodedStrings: List[SimpleEncodedString]) extends EncodedStringTrait {
   override def decode: String = {
    encodedStrings.foldRight("")((simpleEncodedString, baseString) => {
      simpleEncodedString.copy(stringPattern = simpleEncodedString.stringPattern + baseString).decode
    })
  }
}

case object ComplexEncodedString {
  def apply(input: String): ComplexEncodedString =
    val list = input.split('(').map(SimpleEncodedString(_)).toList
    ComplexEncodedString(list)
}

