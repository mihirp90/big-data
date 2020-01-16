package datasets

import org.apache.spark.sql.SparkSession

object MySQLSparkJob {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("My Sql Spark Job").master("local").getOrCreate()

    //val url =fk2sccryhpxhce2r

  }

}
