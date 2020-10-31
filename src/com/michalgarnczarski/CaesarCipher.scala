package com.michalgarnczarski

class CaesarCipher(symbols: Array[Char], key: Int) extends Cipher(symbols) {
  require(key <= symbols.size && key >= 0)

  override protected def transform(text: String, symbols: Array[Char]): String = {

    def auxiliaryTransform(toTransform: String, transformed: String): String = {
      val letterIndex: Int = symbols.indexOf(toTransform.head)
      val newTransformed: String = symbols(letterIndex + key) + transformed
      auxiliaryTransform(toTransform.tail, newTransformed)
    }

    auxiliaryTransform(text, "")
  }

}
