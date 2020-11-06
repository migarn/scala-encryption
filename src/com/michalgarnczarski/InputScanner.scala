package com.michalgarnczarski

import scala.io.StdIn._
import scala.util.Try

object InputScanner {

  def scanIntForSelectionList(instruction: String, allowedInput: Int*): Int = {

    // Function printing an instruction and returning an Int limited by parameters.

    println(instruction)

    // wrongInputValue is an Int not belonging to allowedInput.

    val wrongInputValue: Int = allowedInput.max + 1
    val input: Int = Try(readInt()).orElse(Try(wrongInputValue)).get

    if (allowedInput.contains(input))
      input

    else {
      println("\nWrong input!")
      scanIntForSelectionList(instruction, allowedInput: _*)
    }
  }

  def scanString(instruction: String): String = {
    println(instruction)
    readLine()
  }
}
