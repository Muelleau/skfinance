package io.vigg.skfinance

import breeze.stats.distributions.{
  Gaussian,
  RandBasis,
  ThreadLocalRandomGenerator
}
import org.apache.commons.math3.random.MersenneTwister

object Utils {

  implicit val randBasis: RandBasis = new RandBasis(
    new ThreadLocalRandomGenerator(new MersenneTwister(0))
  )

  val standard_normal = Gaussian.distribution(0, 1)

}
