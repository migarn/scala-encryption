package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

  val reversedSymbols: List[Char] = symbols.reverse

  // Function enabling both encrypting and decrypting of a given text. Decrypting works as encrypting but with
  // reversed alphabet.
  // The transform function's implementation distinguishes different ciphers.

  protected abstract def transform(text: String, symbols: List[Char]): String

  def encryptOnlyLetters(text: String): String = {
    require(text != null)
    transform(text.filter(c => c.isLetter), symbols)
  }

  def decrypt(text: String): String = {
    require(text != null)
    transform(text, reversedSymbols)
  }
}
