package RDDBasics

import org.apache.spark.sql.SparkSession

object RDDWithCSVFile {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark With CSV").master("local").getOrCreate()

    val csvRDD = spark.sparkContext.textFile("src/main/resources/datasets/calendar.csv")

    println(csvRDD.count())
    csvRDD.take(10).foreach(println)

    val header = csvRDD.first()
    val data = csvRDD.filter(_ != header)
    println("After removing header ")
    data.take(10).foreach(println)

    var listing_id = data.map(line => line.split(",")(0))
    println("Displaying only first column")

    listing_id.take(10).foreach(println)

    val arrWithMultipleCol = data.map(line => {
      val temp = line.split(",")
      Array(temp(0), temp(2)).mkString(" ")
    })
    arrWithMultipleCol.take(10).foreach(println)

    arrWithMultipleCol.saveAsTextFile("src/main/resources/datasets/calendar")
  }
}
