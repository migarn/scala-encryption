package com.michalgarnczarski

class CaesarCipher(symbols: Array[Char], key: Int) extends Cipher(symbols) {
  require(key <= symbols.size && key >= 0)

  override protected def transform(text: String, symbols: Array[Char]): String = {

    println("text: " + text) // to be removed

    def auxiliaryTransform(toTransform: String, transformed: String): String = {

      if (toTransform == "") transformed
      else {

        println("toTransform: " + toTransform + ", transformed: " + transformed) // to be removed

        val letterIndex: Int = symbols.indexOf(toTransform.head)

        println("letterIndex: " + letterIndex) // to be removed

        val newTransformed: String = transformed + symbols(letterIndex + key)

        println("newTransformed: " + newTransformed) // to be removed

        auxiliaryTransform(toTransform.tail, newTransformed)

      }
    }

    auxiliaryTransform(text.toUpperCase, "")
  }

}
