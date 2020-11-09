package com.michalgarnczarski

class CaesarCipher(symbols: Array[Char], key: Int) extends Cipher(symbols) {
  require(key <= symbols.length && key >= 0)

  override protected def transform(text: String, innerSymbols: Array[Char]): String = {

    def transformInner(toTransform: String, transformed: String): String = {

      if (toTransform == "") transformed

      // If 'toTransform' is not empty the first character of 'toTransform' is encoded/decoded and moved to 'transformed'.

      else {
        val currentCharacter = toTransform.head
        val newTransformed: String = defineNewTransformed(currentCharacter, transformed)

        transformInner(toTransform.tail, newTransformed)
      }
    }

    def defineNewTransformed(currentCharacter: Char, transformed: String): String = {

      // If current character does not belong to symbols it is not transformed.

      if (!innerSymbols.contains(currentCharacter)) {
        transformed + currentCharacter
      }

      else {
        val characterIndex = innerSymbols.indexOf(currentCharacter)

        // If index exceeds array's length it goes to the array's beginning.

        val newCharacterIndex: Int = {

          if (characterIndex + key > innerSymbols.length - 1)
            characterIndex + key - innerSymbols.length

          else characterIndex + key
        }

        transformed + innerSymbols(newCharacterIndex)
      }
    }

    transformInner(text.toUpperCase, "")
  }
}
