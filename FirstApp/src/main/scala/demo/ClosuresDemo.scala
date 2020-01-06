package demo

object ClosuresDemo {
  //Closures - fn which use one or more variables declare outside this fn
  //Currying is technique of transforming a fn that takes multiple args into a fn that takes single args
  var number = 10;
  var add = (x:Int)=> x + number //closure function

  def add2(x:Int) = (y:Int) => x + y; //currying
 // def add3(x:Int)= (y:Int) = x+y;

  val myArr : Array[Int] = new Array[Int](10);
  //or
  val myArr2 = new Array[Int](10);
  //or
  val myArr3 = Array(1,2,3,4,5);

  //list of scala are immutable and using linked list

  val mylist: List[Int] = List(1,23,4,5,6,7);
  //or

  def main(args: Array[String]): Unit = {
    number = 100 // we can change value of number and again call add fn
    println(add(30));
    println(add2(20)(30));

    val sum = add2(40);
    println(sum(60));
    println(sum(40));//partially applied with currying
    myArr(0) = 20;
    for (x<- myArr){
      println(x);
    }
    println(mylist);
    //colons
    println(0::mylist);
    //Nill
    println(1::2::3::4::Nil);

    println(List.fill(4)(4));

    mylist.foreach(println);

    //sets in scala

    val mySet : Set[Int] = Set(1,2,3,4,4,5);
    println(mySet); //by default all sets are immutable

    //mutable sets
    var mySet1 = scala.collection.mutable.Set(1,2,3,4,4,5,6);
    println(mySet1);
    println(mySet1 + 10);

    //map in scala

    val mymap : Map[Int, String] = Map(1 -> "Mihir", 2 -> "Mayur");

    println(mymap);
    println(mymap.keys);
    println(mymap.values);

    mymap.keys.foreach{
      key => println(" Key " +  key);
            println(" Value " + mymap(key));
    }

    //tuples can contain different data type and its immutable

    val mytuple = (1,2,"Hello", 34.4, false);
    val mytuple2 = new Tuple3(1,2,"Mihir");

    println(mytuple);
    println(mytuple2);
    println(mytuple2._3);

    mytuple2.productIterator.foreach{
      i => println(i);
    }

    //Options (Some or None)
    val mylist2 : List[Int] = List(1,2,3);
    println(mylist2.find(_ > 3));
    println(mylist2.find(_ > 2));
    println(mylist2.find(_ > 2).get);
    println(mylist2.find(_ > 3).getOrElse("No Rec Found"));


    val opt : Option[Int] = Some(4);
    val opt1 : Option[Int] = None;


    println(opt.isEmpty);
    println(opt1.isEmpty);
    println("hello".map(_.toUpper));

    println(List(List(1,2,3), List(4,5,6,7)));
    println(List(List(1,2,3), List(4,5,6,7)).flatten);
    println(mylist2.flatMap(x => List(x, x+1)));
    val alph : List[String] =  List("A", "B", "C");
    println(mylist2.reduceLeft(_ + _));
    println(alph.reduceLeft(_ + _));
    println(alph.reduceRight(_ + _));

    println(mylist2.reduceLeft(_ min _));

    println(mylist2.foldLeft(0)(_ + _));
    println(mylist2.scanLeft(0)(_ + _));

  }
}
