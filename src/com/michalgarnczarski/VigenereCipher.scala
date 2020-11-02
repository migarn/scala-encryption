package com.michalgarnczarski

import scala.annotation.tailrec

class VigenereCipher(symbols: Array[Char], key: String) extends Cipher(symbols) {
  require(key != null && key.toUpperCase.filter(c => !symbols.contains(c)) == "")

  // In require() there is a condition that key is not null and contains only characters belonging to symbols.

  override protected def transform(text: String, symbols: Array[Char]): String = {

    // An auxiliary function implemented to transform text recursively.

    @tailrec
    def auxiliaryTransform(toTransform: String, transformed: String): String = {

      // If 'toTransform' is empty encoding/decoding terminates

      if (toTransform == "") transformed

      // Otherwise first character of 'toTransform' is encoded/decoded and moved to 'transformed'. The function returns
      // itself recursively with 'toTransform' without its first character and 'transformed' appended by this character
      // after encoding/decoding.

      else {
        val currentCharacter = toTransform.head
        val newTransformed: String = defineNewTransformed(currentCharacter, transformed)

        auxiliaryTransform(toTransform.tail, newTransformed)
      }
    }

    def defineNewTransformed(currentCharacter: Char, transformed: String): String = {
      null
    }

    // The function 'transform' returns tailrec function 'auxiliaryTransform'.

    auxiliaryTransform(text.toUpperCase, "")
  }
}
