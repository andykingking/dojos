import org.scalatest.FunSuite
import org.scalatest.prop.TableDrivenPropertyChecks._

class PrisonTransportTest extends FunSuite {

  test("PrisonTransport.run") {
    val inputs = Table(
      ("numberOfInmates", "numberOfInmatePairings", "inmatePairings",     "result"),
      (4,                 2,                        List((1, 2), (1, 4)), 3))

    forAll (inputs) { (numberOfInmates: Int, numberOfInmatePairings: Int, inmatePairings: List[(Int, Int)], result: Int) =>
      assert(PrisonTransport.run(numberOfInmates, numberOfInmatePairings, inmatePairings) === result)
    }
  }

}
