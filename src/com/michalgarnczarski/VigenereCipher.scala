package com.michalgarnczarski

class VigenereCipher(symbols: Array[Char], key: String) extends Cipher(symbols) {
  require(key.toUpperCase.filter(c => !symbols.contains(c)) == "")

  // In require() there is a condition that key contains only characters belonging to symbols.


  override protected def transform(text: String, symbols: Array[Char]): String = ???

}
