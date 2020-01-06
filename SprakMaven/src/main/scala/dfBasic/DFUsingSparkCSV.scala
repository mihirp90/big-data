package dfBasic

import org.apache.spark.sql.SparkSession

object DFUsingSparkCSV {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("DF Using Spark Session CSV").master("local")
      .getOrCreate()

    val df = spark.read.
      //option("header", "true").option("inferSchema", "true").
      options(Map("header" -> "true", "inferSchema" -> "true")).
      csv("src/main/resources/datasets/top50.csv")
    df.printSchema()
    df.show()
  }

}
