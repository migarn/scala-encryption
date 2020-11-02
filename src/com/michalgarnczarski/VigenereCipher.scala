package com.michalgarnczarski

import scala.annotation.tailrec

class VigenereCipher(symbols: Array[Char], key: String) extends Cipher(symbols) {
  require(key != null && key.toUpperCase.filter(c => !symbols.contains(c)) == "")

  // In require() there is a condition that key is not null and contains only characters belonging to symbols.

  override protected def transform(text: String, symbols: Array[Char]): String = {

    // An auxiliary function implemented to transform text recursively.

    @tailrec
    def auxiliaryTransform(toTransform: String, transformed: String, keyCharacterIndex: Int): String = {

      // If 'toTransform' is empty encoding/decoding terminates

      if (toTransform == "") transformed

      // Otherwise first character of 'toTransform' is encoded/decoded and moved to 'transformed'. The function returns
      // itself recursively with 'toTransform' without its first character and 'transformed' appended by this character
      // after encoding/decoding.

      else {
        val currentCharacter = toTransform.head
        val newTransformed: String = defineNewTransformed(currentCharacter, transformed, key(keyCharacterIndex))

        val newCharacterIndex: Int = if (keyCharacterIndex + 1 == key.length) 0 else keyCharacterIndex + 1

        auxiliaryTransform(toTransform.tail, newTransformed, newCharacterIndex)
      }
    }

    def defineNewTransformed(currentCharacter: Char, transformed: String, keyCharacter: Char): String = {

      // Additional auxiliary function defined for clarity.
      // If current character does not belong to symbols it is not transformed.

      if (!symbols.contains(currentCharacter)) {
        transformed + currentCharacter
      }

      else {
        val characterIndex = symbols.indexOf(currentCharacter)

        // to comment

        val keyIndex: Int = symbols.indexOf(keyCharacter.toUpper)

        // Index of letter after transformation is determined regarding symbols array length. If index exceeds
        // array's length it goes to the array's beginning.

        val newCharacterIndex: Int = {

          if (characterIndex + keyIndex > symbols.length - 1)
            characterIndex + keyIndex - symbols.length

          else characterIndex + keyIndex
        }

        transformed + symbols(newCharacterIndex)
      }
    }

    // The function 'transform' returns tailrec function 'auxiliaryTransform'.

    auxiliaryTransform(text.toUpperCase, "", 0)
  }
}
