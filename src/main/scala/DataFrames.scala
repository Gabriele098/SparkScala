import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

// For implicit conversions like converting RDDs to DataFrames
//import spark.implicits._

object DataFrames {
  def main(args:Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()




    val df = spark.read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("mode", "DROPMALFORMED")
      .load("C:\\Users\\Admin\\IdeaProjects\\SparkTry3\\src\\main\\scala\\customers.csv");

    println(df.show())
    // This import is needed to use the $-notation
    import spark.implicits._
    // Print the schema in a tree format
    println(df.printSchema())
  }
}