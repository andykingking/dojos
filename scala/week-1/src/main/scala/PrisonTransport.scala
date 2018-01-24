object PrisonTransport extends App {

  def run(numberOfInmates: Int, pairsOfInmatesHandcuffed: Int, inmatePairings: List[(Int, Int)]) = {
    val prisoners = Prison.addAllPrisoners(numberOfInmates)
    val chainedPrisoners = inmatePairings.foldLeft(prisoners)(Prison.chainPrisoners)

    Prison.chainedGroupSizes(chainedPrisoners).map(Prison.orderBusForChainedGroup).sum
  }

}
