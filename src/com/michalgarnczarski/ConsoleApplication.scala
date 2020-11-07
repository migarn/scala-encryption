package com.michalgarnczarski

import com.michalgarnczarski.InputScanner._

class ConsoleApplication(alphabets: List[Alphabet]) {
  require(alphabets.nonEmpty)

  def run(): String = {

    def innerRun(controller: Int): String = {

      if (controller == 3) "\nThe application has been terminated..."

      else {
        controller match {
          case 1 => encryptOrDecryptMenu(encrypt = true)
          case 2 => encryptOrDecryptMenu(encrypt = false)
        }

        val newController: Int = selectControllerFromMenu()
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
        val menuResult: Boolean = controller match {
          case 1 => alphabetMenu(encrypt, caesar = true)
          case 2 => alphabetMenu(encrypt, caesar = false)
        }

        if (menuResult) true
        else {
          val newController: Int = selectControllerFromMenu()
          innerEncryptOrDecryptMenu(encrypt, newController)
        }
      }
    }

    def selectControllerFromMenu(): Int = scanIntForSelectionList("\nType:" +
      "\n1 - to use Caesar cipher" +
      "\n2 - to use Vigenere cipher" +
      "\n3 - to return",1,2,3)

    innerEncryptOrDecryptMenu(encrypt, selectControllerFromMenu())
  }

  def alphabetMenu(encrypt: Boolean, caesar: Boolean): Boolean = {

    def innerAlphabetMenu(encrypt: Boolean, caesar: Boolean, controller: Int): Boolean = {

      if (controller == alphabets.length + 1) false

      else {
        val menuResult = keyMenu(encrypt, caesar, alphabets(controller - 1))
        if (menuResult) true
        else {
          val newController: Int = selectControllerFromMenu()
          innerAlphabetMenu(encrypt, caesar, newController)
        }
      }
    }

    def generateInstruction(): String = {
      val instructionHead: String = "\nType:"

      def generateSelectionList(appendedInstruction: String, index: Int): String = {
        if (index == alphabets.length) appendedInstruction + "\n" + (index + 1) + " - to return"
        else {
          generateSelectionList(appendedInstruction + "\n" + (index + 1) + " - to use " +
            alphabets(index).name + " alphabet", index + 1)
        }
      }
      generateSelectionList(instructionHead, 0)
    }

    def generateAllowedInput(): List[Int] = (1 to (alphabets.length + 1)).toList

    def selectControllerFromMenu(): Int = scanIntForSelectionList(generateInstruction(), generateAllowedInput():_*)

    innerAlphabetMenu(encrypt, caesar, selectControllerFromMenu())
  }

  def keyMenu(encrypt: Boolean, caesar: Boolean, alphabet: Alphabet): Boolean = {

    def innerKeyMenu(encrypt: Boolean, caesar: Boolean, alphabet: Alphabet, input: String): Boolean = {

      if (input == "-1") false

      else {
        val menuResult: Boolean = {
          try {
            if (caesar) textMenu(encrypt, new CaesarCipher(alphabet.symbols, input.toInt))
            else textMenu(encrypt, new VigenereCipher(alphabet.symbols, input))
          }
          catch {
            case _: IllegalArgumentException => println("\nPlease type correct key.")
              false
          }
        }

        if (menuResult) true
        else {
          val newInput: String = generateInput()
          innerKeyMenu(encrypt, caesar, alphabet, newInput)
        }
      }
    }

    def generateInput(): String = scanString("\nType key or type -1 to return:")
    innerKeyMenu(encrypt, caesar, alphabet, generateInput())
  }

  def textMenu(encrypt: Boolean, cipher: Cipher): Boolean = {

    def innerTextMenu(encrypt: Boolean, cipher: Cipher, input: String): Boolean = {

      if (input == "-1") false

      else {
        val menuResult: Boolean = {
          try {

            if (encrypt) {
              encryptMenu(cipher, input)
            }

            else {
              println("\nDecrypted text:\n" + cipher.decrypt(input))
              true
            }
          }
          catch {
            case _: IllegalArgumentException => println("\nPlease type correct text.")
              false
          }
        }

        if (menuResult) true
        else {
          val newInput: String = generateInput()
          innerTextMenu(encrypt, cipher, newInput)
        }
      }
    }

    def generateInput(): String = scanString("\nType text to " + (if (encrypt) "encrypt" else "decrypt") +
      " or type -1 to return:")
    innerTextMenu(encrypt, cipher, generateInput())
  }

  def encryptMenu(cipher: Cipher, text: String): Boolean = {

    val controller: Int = scanIntForSelectionList("\nType:" +
      "\n1 - to maintain spaces, punctuation and symbols outside the selected alphabet" +
      "\n2 - to reject spaces, punctuation and symbols outside the selected alphabet" +
      "\n3 - to return",1,2,3)

    if (controller == 3) false

    else {
      controller match {
        case 1 => println("\nEncrypted text:\n" + cipher.encryptAll(text))
        case 2 => println("\nEncrypted text:\n" + cipher.encryptOnlyLetters(text))
      }
      true
    }
  }
}
