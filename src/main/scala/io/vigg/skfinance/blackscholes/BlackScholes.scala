package io.vigg.skfinance.blackscholes

import io.vigg.skfinance.Utils.standard_normal

object BlackScholes {

  /* Obtain the black scholes prediction from standard parameters
   *
   * @param option the option type (put or call)
   * @param s the starting price
   * @param k the strike price
   * @param T float maturity in fractions of year
   * @param r risk free interest rate
   * @param v the volalility / diffusion rate
   * */
  def price(
      option: String = "call",
      s: Double,
      k: Double,
      T: Double,
      r: Double,
      v: Double
  ): Double = {
    val d1 = (Math.log(s / k) + (r + v * 2) * T) / (v * Math.sqrt(T))
    val d2 = (Math.log(s / k) - (r + v * 2) * T) / (v * Math.sqrt(T))
    option match {
      case "call" =>
        s * standard_normal.cdf(d1) - k * Math.exp(-r * T) * standard_normal
          .cdf(d2)
      case "put" =>
        k * Math.exp(-r * T) * standard_normal.cdf(-d2) - s * standard_normal(
          -d1
        )
      case _ => throw new java.lang.Exception("invalid option type")
    }
  }

  def vega(s: Double, k: Double, T: Double, r: Double, v: Double): Double =
    s * Math.sqrt(T) *
      standard_normal.pdf(
        (Math.log(s / k) + (r + v * 2) * T) / (v * Math.sqrt(T))
      )

}
