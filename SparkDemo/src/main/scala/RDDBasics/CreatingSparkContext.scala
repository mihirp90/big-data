package RDDBasics

import org.apache.spark.{SparkConf, SparkContext}

object CreatingSparkContext {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("First Spark Application")
    sparkConf.setMaster("local")

    val sc = new SparkContext(sparkConf)

    val arr = Array(1,2,3,4,5,6,7,8,9,0)

    val arrRDD = sc.parallelize(arr,4)

    println(arrRDD.count())

    arrRDD.foreach(println)

    val file = "/Users/mihirprakash/Downloads/19950630.23-19950801.00.tsv"
    val fileRDD = sc.textFile(file)

    println("Number of records in file " + fileRDD.count());

    println(fileRDD.first())

  }
}
