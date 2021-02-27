package proofs.regex

import imaginary.regularLanguageDecider

import proofs.zerosAndOnes

trait Factory extends ((String => Boolean, String) => (String => Boolean))

/**
 * This class does an impossible task: given a machine and input, it decides
 * whether the machine accepts the input
 * @param factory A factory receives two parameters, a function and a string,
 *                and returns another function. Implementations of this trait
 *                should fulfill the following contract:
 *                   * If the function in the first parameter accepts the
 *                   string in the second parameter, the resulting function
 *                   (the factory’s product, so to speak) recognizes some
 *                   regular language. It doesn’t matter which language.
 *                   * Otherwise, the resulting function does not accept
 *                   any regular language.
 */
class UniversalDecider(factory: Factory) extends ((String => Boolean, String) => Boolean) {
  override def apply(fn: (String => Boolean), input: String): Boolean =
    regularLanguageDecider(factory(fn, input))
}

class RegularOrSomethingElse extends Factory {
  override def apply(fn: String => Boolean, input: String): String => Boolean =
    (s: String) => zerosAndOnes(s) || fn(input)
}