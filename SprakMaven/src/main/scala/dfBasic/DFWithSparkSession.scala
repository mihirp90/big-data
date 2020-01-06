package dfBasic

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}

object DFWithSparkSession {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().master("local")
      .appName("Data frame using spark session").getOrCreate()

    val rdd = sparkSession.sparkContext.parallelize(Array(1,2,3,4,5,6))

    val schema = StructType{
      StructField("Number", IntegerType, false) :: Nil
    }

    val rowRDD = rdd.map(e => {
      Row(e)
    })

    val df = sparkSession.createDataFrame(rowRDD, schema)

    df.show()
    df.printSchema()
  }

}
