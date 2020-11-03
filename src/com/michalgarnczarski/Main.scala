package com.michalgarnczarski

object Main {

  def main(args: Array[String]): Unit = {

    // zrefaktorować, żeby tylko auxiliary transform było w poszczególnych klasach. Albo może nawer tylko defineNewTransformed

    val array = Array(1,2,3)
    println(array.length-1)

    val symbols: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

//    val s1 = "BABCIA"
//    val s2 = "BABCIa"
//    val s3 = "BAB CIA"
//    val s4 = "BAB,CIA"
//    val s5 = null
//    val s6 = ""
//
//    println(s1.filter(c => !symbols.contains(c)) == "")
//    println(s2.filter(c => !symbols.contains(c)) == "")
//    println(s3.filter(c => !symbols.contains(c)) == "")
//    println(s4.filter(c => !symbols.contains(c)) == "")
//    println(s6.filter(c => !symbols.contains(c)) == "")

    val alphabet: Alphabet = new Alphabet("Latin", symbols)
    val caesarCipher: CaesarCipher = new CaesarCipher(symbols,10)
    val vigenereCipher: VigenereCipher = new VigenereCipher(symbols,"szyfr")

    val str = "Hello, world"
    val str2 = "Ala ma kota."

//    println(caesarCipher.encryptOnlyLetters(str))
//    println(caesarCipher.encryptAll(str))
//    println(caesarCipher.decrypt(caesarCipher.encryptAll(str)))

    println(vigenereCipher.encryptOnlyLetters(str2))
    println(vigenereCipher.encryptAll(str2))
    println(vigenereCipher.decrypt(vigenereCipher.encryptAll(str2)))

    // Nie działa omijanie symboli spoza



//    println(str.charAt(0))
//
//    println("Hello world.")

  }
}
