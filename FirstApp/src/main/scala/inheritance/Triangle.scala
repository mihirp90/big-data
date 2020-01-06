package inheritance

class Triangle(var w:Double, h:Double) extends Polygon {
  override def area : Double = 0.5*w*h;
}
