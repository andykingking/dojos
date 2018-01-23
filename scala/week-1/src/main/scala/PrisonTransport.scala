object PrisonTransport extends App {
  def run(numberOfInmates: Int, pairsOfInmatesHandcuffed: Int, inmatePairings: List[(Int, Int)]) = {

    var prisoners: Set[Set[Int]] = Set()
    for (prisoner <- 1.to(numberOfInmates)) {
      prisoners = prisoners + Set(prisoner)
    }

    for ((leftPrisoner, rightPrisoner) <- inmatePairings) {
      val leftPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(leftPrisoner) }).get
      val rightPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(rightPrisoner) }).get

      if (leftPrisonerSet != rightPrisonerSet) {
        prisoners = prisoners - (leftPrisonerSet, rightPrisonerSet)
        prisoners = prisoners + (leftPrisonerSet ++ rightPrisonerSet)
      }
    }

    var prisonerGroupSizes: List[Int] = List.empty[Int]
    prisoners.foreach({ prisonerSet => prisonerGroupSizes = prisonerSet.size :: prisonerGroupSizes })

    val totalCost = prisonerGroupSizes
      .map({ (groupSize: Int) => Math.sqrt(groupSize).ceil.toInt }).sum

    totalCost
  }
}
