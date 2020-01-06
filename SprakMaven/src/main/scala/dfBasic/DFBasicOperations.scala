package dfBasic

import org.apache.spark.sql.SparkSession

object DFBasicOperations {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Basic DF Operations").master("local")
      .getOrCreate()

    val dataDF = spark.read.option("header", "true").
      option("inferSchema", "true").csv("src/main/resources/datasets/calendar.csv")
    dataDF.printSchema()

    //op1
    val dataSchema = dataDF.schema //return schema as struct type

    println(dataSchema)

    println(dataDF.columns.mkString(","))

    val columnDesc = dataDF.describe("listing_id")
    columnDesc.show()

    val colAndType = dataDF.dtypes
    colAndType.foreach(println)

    //selecting only desired columns

    dataDF.select("listing_id", "price").show(10)

    //using where clause
    dataDF.select("listing_id", "price").where("price=='$63.00'").
      show(10)

    //or using filter
    dataDF.select("listing_id", "price").filter(dataDF("price") === "$63.00").
      show(10)

    //groupby with count
    dataDF.select("listing_id", "price").groupBy("price").count().
      show()


  }

}
