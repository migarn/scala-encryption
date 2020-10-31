package com.michalgarnczarski

class CaesarCipher(symbols: Array[Char], key: Int) extends Cipher(symbols) {
  require(key <= symbols.size && key >= 0)

  override protected def transform(text: String, symbols: Array[Char]): String = {

    println("text: " + text) // to be removed

    def auxiliaryTransform(toTransform: String, transformed: String): String = {

      if (toTransform == "") transformed
      else {

        println("toTransform: " + toTransform + ", transformed: " + transformed) // to be removed

        val character = toTransform.head

        val newTransformed: String = {
          if (symbols.contains(character)) {

            val characterIndex = symbols.indexOf(toTransform.head)

            val newcharacterIndex: Int = {
              if (characterIndex + key > symbols.length - 1)
                symbols.length - (characterIndex + key)
              else characterIndex + key
            }
            println("characterIndex: " + characterIndex) // to be removed
            transformed + symbols(newcharacterIndex)
          }
          else transformed + character
        }
        println("newTransformed: " + newTransformed) // to be removed
        auxiliaryTransform(toTransform.tail, newTransformed)
      }
    }
    auxiliaryTransform(text.toUpperCase, "")
  }

}
