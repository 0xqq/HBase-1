package com.zxm
import com.sun.org.apache.regexp.internal.RESyntaxException
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util._
import org.apache.hadoop.hbase._
/**
  * Created by zxm on 2018/4/29.
  */
object Demo2 {
  def main(args: Array[String]): Unit = {
    val conf=HBaseConfiguration.create()
    conf.set("hbase.zookeeper.quorum", "hadoop11,hadoop12,hadoop13")
    conf.set("hbase.zookeeper.property.clientPort", "2181")
  val admin:HBaseAdmin = new HBaseAdmin(conf)


    val td = new HTableDescriptor("t8")
    td.addFamily(new HColumnDescriptor("f8"))

    admin.createTable(td)
  }
}
