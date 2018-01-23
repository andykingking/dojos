object Prison {

  var prisoners: Set[Set[Int]] = Set()

  def addAllPrisoners(numberOfInmates: Int): Unit = {
    for (prisoner <- 1.to(numberOfInmates)) {
      prisoners = prisoners + Set(prisoner)
    }
  }

  def chainPrisoners(prisonersToChain: (Int, Int)): Unit = {
    val (leftPrisoner, rightPrisoner) = prisonersToChain
    val leftPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(leftPrisoner) }).get
    val rightPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(rightPrisoner) }).get

    if (leftPrisonerSet != rightPrisonerSet) {
      prisoners = prisoners - (leftPrisonerSet, rightPrisonerSet)
      prisoners = prisoners + (leftPrisonerSet ++ rightPrisonerSet)
    }
  }

  def chainedGroupSizes(): List[Int] = {
    var prisonerGroupSizes: List[Int] = List.empty[Int]
    prisoners.foreach({ prisonerSet => prisonerGroupSizes = prisonerSet.size :: prisonerGroupSizes })
    prisonerGroupSizes
  }

  def orderBusForChainedGroup(groupSize: Int): Int = {
    Math.sqrt(groupSize).ceil.toInt
  }

}
