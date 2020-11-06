package com.michalgarnczarski

object Main {

  def main(args: Array[String]): Unit = {


    val symbols: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')


    val alphabet: Alphabet = new Alphabet("Latin", symbols)
    val caesarCipher: CaesarCipher = new CaesarCipher(symbols,10)
    val vigenereCipher: VigenereCipher = new VigenereCipher(symbols,"szyfr")

    val consoleApplication = new ConsoleApplication(List(alphabet))
    println(consoleApplication.run())




  }
}
