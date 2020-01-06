package dfBasic

import org.apache.spark.sql.SparkSession

object DFBasicOperations {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Basic DF Operations").master("local")
      .getOrCreate()

    val dataDF = spark.read.csv("src/main/resources/datasets/calendar.csv")
    dataDF.printSchema()

    //op1
    val dataSchema = dataDF.schema //return schema as struct type

    println(dataSchema)
  }

}
