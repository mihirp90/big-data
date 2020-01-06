package demo

object Demo {
  object Math{
    def add (x : Int, y:Int): Int = {
      return x + y
    }

    def subtract (x : Int, y:Int): Int = {
      x - y //we can skip writing return keyword
    }

    def square(x : Int) = x*x;
  }
  def main(args: Array[String]): Unit = {
    val name = "Mihir"
    val age = 29
    //string interpolation
    println(name + " is " + age + " years old")
    println(s"$name is $age years old")
    println(f"$name%s is $age%d years old")
    println(s"Hello \n World!!")
    println(raw"Hello \n World!!")

    for (i <- 1 to 5){
      print(i)
    }

    for (i <- 1.until(6) ){
      print(i)
    }
    println()
    for(i <- 1 to 5; j<- 1 to 6){
      println(i + " " + j)
    }

    val lst = List(1,2,3,4,5,6,7)
    for (i<- lst){
      println(i)
    }
    //for loop as expression

    val result = for {i<- lst;if i<7} yield {
      i*i
    }

    println(result)

    val ages = 19

    ages match {
      case 20 => println("matched");
      case 30 => println("younger");
      case 19 => println("older");
        //default case
      case _ => println("Invalid input")

    }
    println(Math.add(12, 13))
    println(Math.square(2)); // or if fn have only one arg then we can call like below
    println(Math square 4);
    println(Math.subtract(23, 10));
    println(multiply(4,5))
    println(divide(45,5))
    println(this.+(12,12));
  }

  def +(x:Int, y:Int) = x+y; // not a operator overloading, just using + as a function name

  def multiply (x : Int, y:Int): Int = x * y; // inline function can avoid {} bracket

  def divide (x : Int, y:Int) = x / y ; //we can avoid writing return type if we certain that fn return that type only
}
