package com.criceta.scala3.sandbox.ctx

/** Given instances (or, simply, “givens”) define "canonical" values of certain types
 * that serve for synthesizing arguments to context parameters.
 *
 * https://docs.scala-lang.org/scala3/reference/contextual/givens.html
 */
trait Ord[T]:
  def compare(x: T, y: T): Int
  extension (x: T) def < (y: T) = compare(x, y) < 0
  extension (x: T) def > (y: T) = compare(x, y) > 0


given intOrd: Ord[Int] with
  def compare(x: Int, y: Int) =
    if x < y then -1 else if x > y then +1 else 0

given listOrd[T](using ord: Ord[T]): Ord[List[T]] with
  def compare(xs: List[T], ys: List[T]): Int = (xs, ys) match
    case (Nil, Nil) => 0
    case (Nil, _)   => 1
    case (_, Nil)   => -1
    case (x :: xs1, y :: ys1) =>
      val fst = ord.compare(x, y)
      if fst != 0 then fst else compare(xs1, ys1)

/** If the name of a given is missing,
 *  the compiler will synthesize a name from the implemented type(s).
 *
 * ```scala
 * given Ord[Int] with
 * ...
 * given [T](using Ord[T]): Ord[List[T]] with
 * ...
 * ```
 *
 * For instance, the two instances above would get the names:
 *
 * - given_Ord_Int
 * - given_Ord_List_T
 *
 * *** Note: To ensure robust binary compatibility,
 * publicly available libraries should prefer named instances. ***
 */

/** Alias givens
 *
 * Scala2 syntax)
 * ```
 * implicit val global: ExecutionContext = ForkJoinPool()
 * ```
 * Scala3 syntax)
 * ```
 * given global: ExecutionContext = ForkJoinPool()
 * ```
 */
