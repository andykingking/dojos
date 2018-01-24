object Prison {

  def addAllPrisoners(numberOfInmates: Int): Set[Set[Int]] = {
    Range(1, numberOfInmates + 1).map(inmate => Set(inmate)).toSet
  }

  def chainPrisoners(prisoners: Set[Set[Int]], prisonersToChain: (Int, Int)): Set[Set[Int]] = {
    val (leftPrisoner, rightPrisoner) = prisonersToChain
    val leftPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(leftPrisoner) }).get
    val rightPrisonerSet: Set[Int] = prisoners.find({ prisonerSet => prisonerSet.contains(rightPrisoner) }).get

    if (leftPrisonerSet != rightPrisonerSet) {
      return prisoners - (leftPrisonerSet, rightPrisonerSet) + (leftPrisonerSet ++ rightPrisonerSet)
    }
    prisoners
  }

  def chainedGroupSizes(prisoners: Set[Set[Int]]): List[Int] = {
    prisoners.toList.map(_.size)
  }

  def orderBusForChainedGroup(groupSize: Int): Int = {
    Math.sqrt(groupSize).ceil.toInt
  }

}
