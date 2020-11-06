package com.michalgarnczarski

import com.michalgarnczarski.InputScanner.scanIntForSelectionList

object ConsoleApplication {

  def run(alphabets: List[Alphabet]): String = {

    def auxiliaryRun(controller: Int): String = {

      if (controller == 3) "\nThe application has been terminated..."

      else {
        controller match {
          case 1 => encryptOrDecryptMenu(true)
          case 2 => encryptOrDecryptMenu(false)
        }

        val newController = mainMenu()
        auxiliaryRun(newController)
      }
    }

    def mainMenu(): Int = scanIntForSelectionList("\nType:" +
      "\n1 - to encrypt text" +
      "\n2 - to decrypt text" +
      "\n3 - to terminate",1,2,3)

    println("\nThe application enables encrypting and decrypting given text by means of two ciphers:" +
      "Caesar cipher and Vigenere cipher.")

    auxiliaryRun(mainMenu())
  }

  def encryptOrDecryptMenu(encrypt: Boolean): Boolean = {

    false
  }
}
