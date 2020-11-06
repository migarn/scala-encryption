package com.michalgarnczarski

import com.michalgarnczarski.InputScanner.scanIntForSelectionList

class ConsoleApplication(alphabets: List[Alphabet]) {

  def run(): String = {

    def innerRun(controller: Int): String = {

      if (controller == 3) "\nThe application has been terminated..."

      else {
        controller match {
          case 1 => encryptOrDecryptMenu(true)
          case 2 => encryptOrDecryptMenu(false)
        }

        val newController = selectControllerFromMenu()
        innerRun(newController)
      }
    }

    def selectControllerFromMenu(): Int = scanIntForSelectionList("\nType:" +
      "\n1 - to encrypt text" +
      "\n2 - to decrypt text" +
      "\n3 - to terminate",1,2,3)

    println("\nThe application enables encrypting and decrypting given text by means of two ciphers:" +
      "Caesar cipher and Vigenere cipher.")

    innerRun(selectControllerFromMenu())
  }

  def encryptOrDecryptMenu(encrypt: Boolean): Boolean = {

    def innerEncryptOrDecryptMenu(encrypt: Boolean, controller: Int): Boolean = {

      if (controller == 3) false

      else {
        controller match {
          case 1 => alphabetMenu(encrypt, true)
          case 2 => alphabetMenu(encrypt, false)
        }

        val newController = selectControllerFromMenu()
        innerEncryptOrDecryptMenu(encrypt, newController)
      }
    }

    def selectControllerFromMenu(): Int = scanIntForSelectionList("\nType:" +
      "\n1 - to use Caesar cipher" +
      "\n2 - to use Vigenere cipher" +
      "\n3 - to return",1,2,3)

    innerEncryptOrDecryptMenu(encrypt, selectControllerFromMenu())
  }

  def alphabetMenu(encrypt: Boolean, caesar: Boolean): Boolean = {

    def innerAlphabetMenu(encrypt: Boolean, caesar: Boolean, controller: Int): Boolean = ???

    val instruction: String = {

      val instructionHead: String = "\nType:"

      def generateSelectionList(appendedInstruction: String, index: Int): String = {
        if (index == alphabets.length + 1) appendedInstruction
        else {
          generateSelectionList(appendedInstruction + "\n" + index + " - to use " + alphabets(index).name, index + 1)
        }
      }

      generateSelectionList(instructionHead, 0)
    }

    val allowedInput: List[Int] = for (a <- alphabets) yield alphabets.indexOf(a) + 1

    def selectControllerFromMenu(): Int = scanIntForSelectionList(instruction, allowedInput:_*)

    innerAlphabetMenu(encrypt, caesar, selectControllerFromMenu())
  }
}
