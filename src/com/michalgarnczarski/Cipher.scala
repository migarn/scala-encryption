package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

  // Function enabling both encrypting and decrypting of a given text. Decrypting works as encrypting but with
  // reversed alphabet.

  protected abstract def transform(text: String, symbols: Array[Char])

}
