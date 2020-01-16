package datasets

import org.apache.spark.sql.SparkSession

object FileToHive {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Temp Table").master("local").getOrCreate()

    val dataFrame = spark.read.option("header", "true").option("inferSchema", "true").csv("src/main/resources/datasets/calendar.csv")

  }
}
