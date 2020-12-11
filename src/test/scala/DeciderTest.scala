import org.scalatest.funsuite.AnyFunSuite
import proofs.regex.UniversalDecider
import proofs.{loop, zerosAndOnes, zerosAtTheEdges}

class DeciderTest extends AnyFunSuite {

  test("Function accepts its input") {
    val decider = new UniversalDecider((_, _) => zerosAtTheEdges)

    assert(decider.apply(zerosAtTheEdges, "01110"))
  }

  test("Function does not accept its input") {
    val decider = new UniversalDecider((_, _) => zerosAndOnes)

    assert(!decider.apply(zerosAtTheEdges, "11"))
  }

  test("Function loops forever") {
    val decider = new UniversalDecider((_, _) => zerosAndOnes)

    assert(!decider.apply(loop, "11"))
  }
}
