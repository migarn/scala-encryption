package com.michalgarnczarski

import scala.annotation.tailrec

class CaesarCipher(symbols: Array[Char], val key: Int) extends Cipher(symbols) {
  require(key <= symbols.length && key >= 0)

  override protected def transform(text: String, innerSymbols: Array[Char]): String = {

    // An auxiliary function implemented to transform text recursively.

    @tailrec
    def auxiliaryTransform(toTransform: String, transformed: String): String = {

      // If 'toTransform' is empty encoding/decoding terminates

      if (toTransform == "") transformed

      // Otherwise the first character of 'toTransform' is encoded/decoded and moved to 'transformed'. The function returns
      // itself recursively with 'toTransform' without its first character and 'transformed' appended by this character
      // after encoding/decoding.

      else {
        val currentCharacter = toTransform.head
        val newTransformed: String = defineNewTransformed(currentCharacter, transformed)

        auxiliaryTransform(toTransform.tail, newTransformed)
      }
    }

    def defineNewTransformed(currentCharacter: Char, transformed: String): String = {

      // Additional auxiliary function defined for clarity.
      // If current character does not belong to symbols it is not transformed.

      if (!innerSymbols.contains(currentCharacter)) {
        transformed + currentCharacter
      }

      else {
        val characterIndex = innerSymbols.indexOf(currentCharacter)

        // Index of letter after transformation is determined regarding symbols array length. If index exceeds
        // array's length it goes to the array's beginning.

        val newCharacterIndex: Int = {

          if (characterIndex + key > innerSymbols.length - 1)
            characterIndex + key - innerSymbols.length

          else characterIndex + key
        }

        transformed + innerSymbols(newCharacterIndex)
      }
    }

    // The function 'transform' returns tailrec function 'auxiliaryTransform'.

    auxiliaryTransform(text.toUpperCase, "")
  }
}
