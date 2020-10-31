package com.michalgarnczarski

object Main {

  def main(args: Array[String]): Unit = {

    val array = Array(1,2,3)
    println(array.length-1)

    val symbols: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val alphabet: Alphabet = new Alphabet("Latin", symbols)
    val caesarCipher: CaesarCipher = new CaesarCipher(symbols,10)
    val str = "Hello, world"

    println(caesarCipher.encryptOnlyLetters(str))
    println(caesarCipher.encryptAll(str))
    println(caesarCipher.decrypt(caesarCipher.encryptAll(str)))



//    println(str.charAt(0))
//
//    println("Hello world.")

  }
}
