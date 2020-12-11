package proofs.regex

import imaginary.regularLanguageDecider

import proofs.zerosAndOnes

trait Factory extends ((String => Boolean, String) => (String => Boolean))

/**
 * This class does an impossible task: given a machine and input, it decides
 * whether the machine accepts the input
 * @param factory A special factory blablabla
 */
class UniversalDecider(factory: Factory) extends ((String => Boolean, String) => Boolean) {
  override def apply(fn: (String => Boolean), input: String): Boolean =
    regularLanguageDecider(factory(fn, input))
}

class RegularOrSomethingElse extends Factory {
  override def apply(fn: String => Boolean, input: String): String => Boolean =
    (s: String) => zerosAndOnes(s) || fn(input)
}