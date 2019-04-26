object StringEncoderAndDecoder {


  def main(args: Array[String]) {
    println("Please enter string you need to check Encode it ....")
    val  n = scala.io.StdIn.readLine()

    println(runLengthEncode(n))
  }
  def runLengthEncode(n: String):String= {
    var count = 0
    var currentChar : String  =""
    var finalString : String =""
    for (c <- n)  {
      if (currentChar.isEmpty()){
       currentChar=c.toString
      }
      if(c.toString().equals(currentChar)){
        count=count + 1
      }
      else if (!(c.toString().equals(currentChar))){
        finalString=finalString.concat(currentChar.toString).concat(count.toString)
        currentChar=c.toString
        count=1
      }
    }
    finalString=finalString.concat(currentChar.toString).concat(count.toString)
    return finalString
  }
  
}
