package com.michalgarnczarski

import scala.annotation.tailrec
import scala.io.StdIn.readInt
import scala.util.Try

object InputScanner {

  @tailrec
  def scanIntForSelectionList(instruction: String, allowedInput: Int*): Int = {

    // Function printing an instruction and returning an Int limited by parameters.
    // The function works recursively until correct input is typed.

    println(instruction)

    // wrongInputValue is an Int returned for incorrect inputs. It is an Int which unfailingly is not an allowedInput.

    val wrongInputValue: Int = allowedInput.max + 1
    val input: Int = Try(readInt()).orElse(Try(wrongInputValue)).get

    if (allowedInput.contains(input))
      input

    else {
      println("\nWrong input!")
      scanIntForSelectionList(instruction, allowedInput: _*)
    }
  }

}
