package dfBasic

import org.apache.spark.sql.SparkSession

/**
 * IF we are working on spark 2.0 or above, then it will support
 * CSV, JSON, ORC, PARQUET file format.
 * but spark 1.0 not support csv file format
 */

object FileFormats {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("DF File Formats")
      .master("local").getOrCreate()

    val jsonDF = spark.read.json("src/main/resources/datasets/file1.json")

    jsonDF.show()
  }
}
