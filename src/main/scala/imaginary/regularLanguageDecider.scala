package imaginary

import proofs.{anything, zerosAtTheEdges}

/**
 * Given a function, tells whether that function recognizes a regular language
 */
object regularLanguageDecider extends ((String => Boolean) => Boolean) {
  override def apply(fn: String => Boolean): Boolean =
    fn == zerosAtTheEdges || fn == anything
}

