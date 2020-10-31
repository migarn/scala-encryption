package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

  // The class enables both encrypting and decrypting given texts. The class is implemented as abstract class with
  // abstract transform function.
  // Encrypting and decrypting is carried out in the same function, but with the regular or reversed symbols list.

  val reversedSymbols: List[Char] = symbols.reverse

  // The transform function is meant to both encrypting and decrypting. The function's implementation
  // depends on a specific cipher.

  protected def transform(text: String, symbols: List[Char]): String

  // The function encrypts the entire text. Symbols outside given symbols list remain unencrypted.

  def encryptAll(text: String): String = {
    require(text != null)
    transform(text, symbols)
  }

  // The function encrypts only symbols within given symbols list. Other symbols are deleted.

  def encryptOnlyLetters(text: String): String = {
    require(text != null)
    transform(text.filter(_.isLetter), symbols)
  }

  // The function decrypts the entire text. Symbols outside given symbols list remain undecrypted.

  def decrypt(text: String): String = {
    require(text != null)
    transform(text, reversedSymbols)
  }
}
