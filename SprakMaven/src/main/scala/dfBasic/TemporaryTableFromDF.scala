package dfBasic

import org.apache.spark.sql.SparkSession

object TemporaryTableFromDF {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Temp Table").master("local").getOrCreate()

    val dataFrame = spark.read.option("header", "true").option("inferSchema", "true").csv("src/main/resources/datasets/calendar.csv")

    dataFrame.registerTempTable("calendar_table")//deprecated method

    spark.sql("select * from calendar_table limit 10").show()

    //spark 2.0
    dataFrame.createGlobalTempView("calendar_tb")
    spark.sql("select * from calendar_tb limit 10").show()
    dataFrame.createOrReplaceGlobalTempView("calendar_tbb")//override table fn present



  }

}
