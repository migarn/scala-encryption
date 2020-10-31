package com.michalgarnczarski

abstract class Cipher(val symbols: List[Char]) {

  // The class enables both encrypting and decrypting given texts. The class is implemented as abstract class with
  // abstract transform function.
  // Encrypting and decrypting is carried out in the same function, but with the regular or reversed symbols list.

  val reversedSymbols: List[Char] = symbols.reverse

  // The transform function is meant to both encrypting and decrypting. The function's implementation
  // depends on a specific cipher.

  protected def transform(text: String, symbols: List[Char]): String

  def encryptAll(text: String): String = {

    // The function encrypts the entire text. Symbols outside given symbols list remain unencrypted.

    require(text != null)
    transform(text, symbols)
  }

  def encryptOnlyLetters(text: String): String = {

    // The function encrypts only symbols within given symbols list. Other symbols are deleted.

    require(text != null)
    transform(text.filter(_.isLetter), symbols)
  }

  def decrypt(text: String): String = {

    // The function decrypts the entire text. Symbols outside given symbols list remain undecrypted.

    require(text != null)
    transform(text, reversedSymbols)
  }
}
