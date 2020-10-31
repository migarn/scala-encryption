package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

  val reversedSymbols: List[Char] = symbols.reverse

  // Function enabling both encrypting and decrypting of a given text. Decrypting works as encrypting but with
  // reversed alphabet.

  protected abstract def transform(text: String, symbols: Array[Char])

}
