package code.book.stream.datastreamapi

import org.apache.flink.streaming.api.scala._

object Reduce002 {
  def main(args: Array[String]): Unit = {
    //1.创建流处理环境
    val senv = StreamExecutionEnvironment.getExecutionEnvironment

    //2.准备数据
    val text = senv.fromElements((1, 3), (2, 4),( 6, 5))

    //3.执行运算
    val result: DataStream[String] =
    text.keyBy(0).fold("start")((str, i) => str + "-" + i)

    //4.将结果打印出来
    result.print()

    //5.触发流计算
    senv.execute(this.getClass.getName)
  }
}
