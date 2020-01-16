package datasets

import org.apache.spark.sql.SparkSession

case class Calendar(listing_id:Integer, date:String, available:String, price:String, adjusted_price:String,
                    minimum_nights:String, maximum_nights:String)
object DatasetsBasic extends App {

  val spark = SparkSession.builder().appName("Data Sets").master("local").getOrCreate()
  import spark.implicits._
  val calendarDS = spark.read.option("header", "true").option("inferSchema", "true").csv("src/main/resources/datasets/calendar.csv")
    .as[Calendar]
  calendarDS.show()

  val filterDemo = calendarDS.filter(obj => obj.price == "$63.00")

  filterDemo.show()

  println("No of records " + filterDemo.count())

  val whereDemo = calendarDS.where("price == $63.00")

  whereDemo.show()

}
