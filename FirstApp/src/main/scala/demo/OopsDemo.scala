package demo
import java.util.Date;
object OopsDemo {
  //Unit == Void
  def main(args: Array[String]): Unit = {
    //anonymous function
    var add = (x : Int, y : Int) => x+y;
    println(add(300,500))

    println(math(34,35,(x,y)=>x+y));
    println(math(34,35,(x,y) => x/y));
    println(mathWithThreeArg(23,45,67,(x,y)=> x min y));
    println(mathWithThreeArg(34,56,78, _+_)) //more compact way of writing function

    val sum = (x:Int, y:Int, z:Int) => x + y + z;
    val f = sum(20,30,_:Int);
    println("Fully Applied Function " + sum(10,20,30) );
    println("Partially Applied Function " + f(10) );

    val date = new Date;
    val new_log = log(date, _ : String); //partially applied fn
    new_log("Message 1");
  }
  //higher order function

  def math(x:Double, y:Double, f:(Double, Double) => Double) : Double =  f(x,y);
  def mathWithThreeArg(x:Double, y:Double, z:Double, f:(Double, Double) => Double): Double =  f(f(x,y), z);

  //partially applied function example
  def log(date:Date, message:String): Unit = {
    println(s"$date and $message");
  }

  //Closures - fn which use one or more variables declare outside this fn
}
