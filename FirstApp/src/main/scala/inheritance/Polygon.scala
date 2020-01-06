package inheritance

/*class Polygon {

  def area: Double = 0.0;

}*/

abstract  class Polygon {
  def area: Double = 0.0;
}

object Polygon{
  def main(args: Array[String]): Unit = {
    //var poly = new Polygon;
    var rect = new Rectangle(34,12);
    var tri = new Triangle(12,56);
    //printArea(poly);
    printArea(rect);
    printArea(tri);
  }

  def printArea(p:Polygon): Unit ={
    println(p.area);
  }
}
