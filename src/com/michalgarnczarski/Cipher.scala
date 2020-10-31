package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

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
  // Decryption is carried out in the same way as encryption but with reversed symbols list.

  def decrypt(text: String): String = {
    require(text != null)
    transform(text, symbols.reverse)
  }
}
