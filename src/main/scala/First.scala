import scala.annotation.tailrec

object First extends App {

  def solution(from: Int, to: Int): Either[String, (Int, Int)] = {
    val refine = (v: Int) => (s: String) => for {
      _ <- Either.cond(!(v < 2), (), s"Value $s is less than 2")
      _ <- Either.cond(!(v > 1000000000), (), s"Value $s is greater than 1000000000")
    } yield ()

    @tailrec
    def justLoop(v: Int, c: Int = 0): (Int, Int) = {
      v match {
        case v if v < 4 => (v, c)
        case _ => justLoop(math.sqrt(v).toInt, c + 1)
      }
    }

    @tailrec
    def stupidLoop(like: Int, c: Int = 0): Int = {
      val next = math.sqrt(like)
      if (next.isValidInt) stupidLoop(next.toInt, c + 1) else c
    }

    for {
      _ <- Either.cond(to >= from, (), "Value from is greater then to")
      _ <- refine(from)("from")
      _ <- refine(to)("to")
    } yield {
      val (value, n) = justLoop(to)
      val powered = math.pow(value, math.pow(2, n)).toInt
      if (powered >= from) {
        (powered, n)
      } else {
        (from to to).foldLeft((0, 0)) { case (acc @ (_, prevN), next) =>
          val newN = stupidLoop(next)
          if (newN > prevN) (next, newN) else acc
        }
      }
    }
  }
}
