package com.michalgarnczarski

class VigenereCipher(symbols: Array[Char], key: String) extends Cipher(symbols) {

  override protected def transform(text: String, symbols: Array[Char]): String = ???

}
