package dfBasic

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{BooleanType, DateType, LongType, StringType, StructField, StructType}

object ImposingOwnSchema {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("Avro File format")
      .getOrCreate()

    val nameDF = spark.read.option("header", "true").option("inferSchema", "true")
      .csv("src/main/resources/datasets/calendar.csv")

    nameDF.printSchema()

    val ownSchema = StructType(
      StructField("listing_id", LongType, true) ::
        StructField("date", DateType, true) ::
        StructField("available", StringType, true) ::
        StructField("price", StringType, true) ::
        StructField("adjusted_price", StringType, true) ::
        StructField("minimum_nights", LongType, true) ::
        StructField("maximum_nights", LongType, true) ::Nil
    )

    val nameWithOwnSchema = spark.read.option("header", "true").schema(ownSchema).csv("src/main/resources/datasets/calendar.csv")

    nameWithOwnSchema.printSchema()

    nameWithOwnSchema.show()
  }
}
