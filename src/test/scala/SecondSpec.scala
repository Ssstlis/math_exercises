import org.scalatest.WordSpec

class SecondSpec extends WordSpec {
  "Second#solution" should {
    "return valid result for value less than ten" in {
      assert(Second.solution(9) == Right(0))
      assert(Second.solution(1) == Right(0))
      assert(Second.solution(4) == Right(0))
    }

    "return valid result for value less than one (error)" in {
      assert(Second.solution(0) == Left("Value is less than 1"))
      assert(Second.solution(-12) == Left("Value is less than 1"))
      assert(Second.solution(-3278) == Left("Value is less than 1"))
    }

    "return valid result for value greater than 1000000000 (error)" in {
      assert(Second.solution(1000000001) == Left("Value is greater than 1000000000"))
      assert(Second.solution(1000000002) == Left("Value is greater than 1000000000"))
      assert(Second.solution(1002300000) == Left("Value is greater than 1000000000"))
    }

    "return valid result" in {
      assert(Second.solution(10) == Right(10))
      assert(Second.solution(143) == Right(100))
      assert(Second.solution(9236778) == Right(1000000))
    }
  }
}
