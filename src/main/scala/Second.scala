
object Second extends App {

  def solution(value: Int): Either[String, Int] = {

    def loop(value: Int): Int = {
      if (value < 10) 1 else 10 * loop(value / 10)
    }

    for {
      _ <- Either.cond(!(value < 1), (), "Value is less than 1")
      _ <- Either.cond(!(value > 1000000000), (), "Value is greater than 1000000000")
    } yield if (value < 10) 0 else loop(value)
  }
}
