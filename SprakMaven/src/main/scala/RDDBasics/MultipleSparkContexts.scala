package RDDBasics

import org.apache.spark.{SparkConf, SparkContext}

object MultipleSparkContexts {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Multiple Spark Contexts").setMaster("local")

    val sc = new SparkContext(sparkConf)

    val sc1 = new SparkContext(sparkConf)

    val rdd = sc.parallelize(Array(1,2,3,4,5))
    val rdd1 = sc1.parallelize(Array(6,7,8,9,0))

    rdd.collect()
    rdd1.collect()
  }

}
