package com.michalgarnczarski

class CaesarCipher(symbols: List[Char], key: Int) extends Cipher(symbols) {
  require(key <= symbols.size && key >= 0)

  override def transform(text: String, symbols: List[Char]): String = {

  }

}
