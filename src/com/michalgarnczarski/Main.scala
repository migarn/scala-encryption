package com.michalgarnczarski

object Main {

  def main(args: Array[String]): Unit = {

    val latinSymbols: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
      'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val polishSymbols: Array[Char] = Array('A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
      'Ł', 'M', 'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S', 'Ś', 'T', 'U', 'W', 'Y', 'Z', 'Ź', 'Ż')
    val polishExtendedSymbols: Array[Char] = Array('A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J',
      'K', 'L', 'Ł', 'M', 'N', 'Ń', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'Ś', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ź', 'Ż')

    val latinAlphabet: Alphabet = new Alphabet("Latin alphabet", latinSymbols)
    val polishAlphabet: Alphabet = new Alphabet("Polish alphabet", polishSymbols)
    val polishExtendedAlphabet: Alphabet = new Alphabet("Polish extended alphabet", polishExtendedSymbols)

    println(new ConsoleApplication(List(latinAlphabet, polishAlphabet, polishExtendedAlphabet)).run())
  }
}
