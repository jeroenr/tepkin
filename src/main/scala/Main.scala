import java.util.concurrent.atomic.AtomicInteger

import akka.util.Timeout
import net.fehmicansaglam.tepkin.MongoClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main {

  def main(args: Array[String]): Unit = {
    val mongoClient = MongoClient("localhost", 27017)

    implicit val timeout: Timeout = 50.seconds

    val index = new AtomicInteger(1)

    val start = System.currentTimeMillis()
    1 to 1000 foreach { i =>
      mongoClient("colossus", "abuzer").count().foreach { result =>
        println(s"${index.getAndIncrement}. ${result.n}")
        println(System.currentTimeMillis() - start)
      }
    }

    mongoClient.shutdown()
  }
}
