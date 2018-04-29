package com.zxm

import com.sun.org.apache.regexp.internal.RESyntaxException
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util._
import org.apache.hadoop.hbase._

/**
  * Created by zxm on 2018/4/29.
  */
class HBaseClient(val b: String, val p: String) {

  val brokers: String = b
  val port = p
  var conn: Connection = null

//  init()

  def init(): Unit = {
    val conf = HBaseConfiguration.create
    conf.set("hbase.zookeeper.quorum", brokers)
    conf.set("hbase.zookeeper.property.clientPort", port)

    try {
      conn = ConnectionFactory.createConnection(conf)
    } catch {
      case e: Exception => {
        println(e)
      }
    }
  }

  def createTable(t: String, c: Array[String]): Unit = {
    init()
    val admin = conn.getAdmin
    val tableName = TableName.valueOf(t)
    if (!admin.tableExists(tableName)) {
      val td = new HTableDescriptor(tableName)
      if (c.length > 0) {
        for (i <- 0 to (c.length - 1)) {
          td.addFamily(new HColumnDescriptor(c(i)))
        }
      }
      admin.createTable(td)
      admin.close()
      conn.close()
    }
  }

}
