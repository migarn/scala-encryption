package com.michalgarnczarski

class VigenereCipher(symbols: Array[Char], key: String) extends Cipher(symbols) {
  require(key != null && key.toUpperCase.filter(c => !symbols.contains(c)) == "")

  // In require() there is a condition that key is not null and contains only characters belonging to symbols.

  override protected def transform(text: String, innerSymbols: Array[Char]): String = {

    def transformInner(toTransform: String, transformed: String, keyCharacterIndex: Int): String = {

      if (toTransform == "") transformed

      // If 'toTransform' is not empty the first character of 'toTransform' is encoded/decoded and moved to 'transformed'.

      else {
        val currentCharacter = toTransform.head
        val newTransformed: String = defineNewTransformed(currentCharacter, transformed, key(keyCharacterIndex))

        // If current character does not belong to symbols key character will be used with another character.

        if (innerSymbols.contains(currentCharacter)) {
          val newKeyCharacterIndex: Int = if (keyCharacterIndex + 1 == key.length) 0 else keyCharacterIndex + 1
          transformInner(toTransform.tail, newTransformed, newKeyCharacterIndex)
        }

        else transformInner(toTransform.tail, newTransformed, keyCharacterIndex)
      }
    }

    def defineNewTransformed(currentCharacter: Char, transformed: String, keyCharacter: Char): String = {

      // If current character does not belong to symbols it is not transformed.

      if (!innerSymbols.contains(currentCharacter)) {
        transformed + currentCharacter
      }

      else {
        val characterIndex = innerSymbols.indexOf(currentCharacter)

        // Current key index is defined based on symbols, not innerSymbols! Crucial for decrypting (reversed alphabet)!

        val keyIndex: Int = symbols.indexOf(keyCharacter.toUpper)

        // If index exceeds array's length it goes to the array's beginning.

        val newCharacterIndex: Int = {

          if (characterIndex + keyIndex > innerSymbols.length - 1)
            characterIndex + keyIndex - innerSymbols.length

          else characterIndex + keyIndex
        }

        transformed + innerSymbols(newCharacterIndex)
      }
    }

    transformInner(text.toUpperCase, "", 0)
  }
}
