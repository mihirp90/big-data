package inheritance

class Rectangle(var w:Double, h:Double) extends Polygon {
  override def area : Double = w*h;
}
