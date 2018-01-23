object PrisonTransport extends App {

  def run(numberOfInmates: Int, pairsOfInmatesHandcuffed: Int, inmatePairings: List[(Int, Int)]) = {
    Prison.addAllPrisoners(numberOfInmates)

    inmatePairings.foreach({ Prison.chainPrisoners })

    Prison.chainedGroupSizes().map(Prison.orderBusForChainedGroup).sum
  }

}
