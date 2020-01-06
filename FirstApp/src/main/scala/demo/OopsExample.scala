package demo

class User(var name : String, private var age : Int){
  //auxiliary constructor
  //default constructor
  def this(){
    this("Amar", 25);
  }

  def this(name:String){
    this(name, 26);
  }
  def getAge():Int = {return this.age;}
}

class strict{
  val e = {
    println("strict");
    9
  }
}

class LazyEval{
  lazy val l = {
    println("lazy");
    9
  }
}

object OopsExample {

  def method1(n : Int): Unit ={
    println("method1")
    println(n);
  }

  def method2(n : => Int): Unit ={ //call by name method
    println("method2")
    println(n);
  }

  def main(args: Array[String]): Unit = {
    var user = new User("Mihir", 29);
    var user1 = new User;
    var user2 = new User("Mayur");
    println(user.name);
    println(user1.name);
    println(user2.name);
    //println(user.age) will give error as age is private
    println(user.getAge());
    val x = new strict;
    val y = new LazyEval;

    val add = (a:Int, b:Int) => {
      println("add");
      a + b;
    }

    method1(add(10,20));
    method2(add(10,20));
  }
}
