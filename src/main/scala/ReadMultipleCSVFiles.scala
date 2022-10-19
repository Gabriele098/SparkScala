
//package com.sparkbyexamples.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object ReadMultipleCSVFiles extends App {

  val spark = SparkSession.builder().master("local[*]").appName("SparkTry3").getOrCreate()

  val df = spark.read.format("com.databricks.spark.csv").
    option("header", "true").option("mode", "DROPMALFORMED").
    load("C:\\Users\\Admin\\IdeaProjects\\SparkTry3\\src\\main\\scala\\customers.csv")

  println(df.show(5))
  println(df.printSchema())
}
