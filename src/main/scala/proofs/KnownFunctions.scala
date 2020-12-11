package proofs

object zerosAtTheEdges extends (String => Boolean) {
  override def apply(s: String): Boolean = s.matches("01*0")
}

object anything extends (String => Boolean) {
  // We could simply return true, but this explicit regex drives the point home better
  override def apply(s: String): Boolean = s.matches(".*")
}

object zerosAndOnes extends (String => Boolean) {
  override def apply(s: String): Boolean = {
    val (zeros, rest) = s.span(_ == '0')
    zeros.length == rest.length && rest.forall(_ == '1')
  }
}

object loop extends (String => Boolean) {
  override def apply(s: String): Boolean = {
    if ("0000" equals s) true
    else {
      while (true) {}
      false
    }
  }
}