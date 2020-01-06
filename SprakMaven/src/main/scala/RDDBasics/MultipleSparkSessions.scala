package RDDBasics

import org.apache.spark.sql.SparkSession

object MultipleSparkSessions {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local")
      .appName("Multiple Spark Session").getOrCreate()

    val spark1 = SparkSession.builder().master("local")
      .appName("Multiple Spark Session").getOrCreate()

    val rdd = spark.sparkContext.parallelize(Array(1,2,3,4,5))
    val rdd1 = spark1.sparkContext.parallelize(Array(5,6,7,8,9))

    rdd.collect().foreach(println)
    rdd1.collect().foreach(println)
  }

}
