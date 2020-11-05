package com.michalgarnczarski

import com.michalgarnczarski.InputScanner.scanIntForSelectionList

import scala.annotation.tailrec

object ConsoleApplication {

  def run(alphabets: List[Alphabet]): String = {

    @tailrec
    def auxiliaryRun(controller: Int): String = {

      if (controller == 3) "\nThe application has been terminated..."

      else {
        controller match {
          case 1 => println("encrypt") // encryptdecrypt e
          case 2 => println("decrypt") // encryptdecrypt d
        }

        val newController = mainMenu()
        auxiliaryRun(newController)
      }
    }

    def mainMenu(): Int = scanIntForSelectionList("\nType:" +
      "\n1 - to encrypt text" +
      "\n2 - to decrypt text" +
      "\n3 - to terminate",1,2,3)

    println()
    auxiliaryRun(mainMenu())
  }
}
