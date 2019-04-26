object Palindrome {


    def main(args: Array[String]) {
      println("Please enter string you need to check it palindromic....")
      val  palindromeString = scala.io.StdIn.readLine()
      println(palindrome(palindromeString))
    }

    def palindrome(palindromeString: String): Boolean = {
      val reversalString=palindromeString.reverse
      return palindromeString==reversalString

    }


}
