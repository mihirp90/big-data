package dfBasic

import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * In spark 1.x data frame is created using SQLContext
 * and SQLContext is created using SparkContext
 */
object DFWithSparkContext {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf();
    sparkConf.setMaster("local")
    sparkConf.setAppName("My First Data Frame")

    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)
    val rdd = sc.parallelize(Array(1,2,3,4,5,6,7,8,9))
    val schema = StructType{
      StructField("number", IntegerType, false)::Nil
    }

    val rowRDD = rdd.map(line => Row(line))

    val df = sqlContext.createDataFrame(rowRDD,schema)
    df.printSchema()
    df.show(10)
  }
}
