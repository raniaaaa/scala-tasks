object Factorial {

  def main(args: Array[String]) {

    println("Please enter string you need to check it palindromic....")
    val  number = scala.io.StdIn.readInt()
    println(factorial(number))
  }

  def factorial(number: Int): Int = {
    if (number == 0)
      return 1
    else
      return number * factorial(number-1)
  }

}
