import org.scalatest.WordSpec

class FirstSpec extends WordSpec {
  "First#solution" should {
    "return error 1" in {
      assert(First.solution(2, 1) == Left("Value from is greater then to"))
    }

    "return errors about \"from\"" in {
      assert(First.solution(-2, 6) == Left("Value from is less than 2"))
      assert(First.solution(1000000001, 1000000002) == Left("Value from is greater than 1000000000"))
    }

    "return errors about \"to\"" in {
      assert(First.solution(1000, 1000000002) == Left("Value to is greater than 1000000000"))
    }

    "return valid" in {
      assert(First.solution(2, 7000) == Right(6561, 3))
      assert(First.solution(2, 32) == Right(16, 2))
      assert(First.solution(2, 256) == Right(256, 3))
      assert(First.solution(2, 289) == Right(256, 3))
      assert(First.solution(240000, 262144) == Right(240100, 1))
      assert(First.solution(240000, 262154) == Right(240100, 1))
      assert(First.solution(240000, 262134) == Right(240100, 1))
    }
  }
}
