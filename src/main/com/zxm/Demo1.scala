package com.zxm

import org.apache.hadoop.hbase.ipc.TestHBaseClient

/**
  * Created by zxm on 2018/4/29.
  */
object Demo1 {

  def main(args: Array[String]): Unit = {
    println("BEGIN")
    val c:HBaseClient = new HBaseClient("hadoop11,hadoop12,hadoop13","2181")

    c.createTable("student",Array("name","age"))

    println("END")
  }

}
