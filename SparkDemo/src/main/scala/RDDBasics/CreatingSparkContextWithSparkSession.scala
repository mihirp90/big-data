package RDDBasics

import org.apache.spark.sql.SparkSession

object CreatingSparkContextWithSparkSession {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().appName("Second Spark App").master("local")
      .getOrCreate()

    val arr = Array(1,2,3,4,5,6,7,8,9,0)

    val arrRDD = sparkSession.sparkContext.parallelize(arr, 3)

    println(arrRDD.count())
    arrRDD.foreach(println)

  }
}
