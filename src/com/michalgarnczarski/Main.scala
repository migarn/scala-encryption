package com.michalgarnczarski

object Main {

  def main(args: Array[String]): Unit = {


    val symbols: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')


    val alphabet: Alphabet = new Alphabet("Latin", symbols)
    val caesarCipher: CaesarCipher = new CaesarCipher(symbols,10)
    val vigenereCipher: VigenereCipher = new VigenereCipher(symbols,"szyfr")

    val consoleApplication = new ConsoleApplication(List(alphabet))
    println(consoleApplication.run())

//    symbols.foreach(s => println(s.getNumericValue))

    val alphabet2: Alphabet = new Alphabet("Latin2", symbols)

    val alphabets = List(alphabet, alphabet2)

    val allowedInput: List[Int] = for (a <- alphabets) yield alphabets.indexOf(a) + 1

    println(allowedInput)




  }
}
