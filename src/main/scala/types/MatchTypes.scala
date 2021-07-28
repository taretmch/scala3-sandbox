package com.criceta.scala3.sandbox.types

/** Match type
 *
 * http://dotty.epfl.ch/docs/reference/new-types/match-types.html
 */
type Elem[X] = X match
  case String => Char
  case Array[t] => t
  case Iterable[t] => t

/** Recursive match types */
type LeafElem[X] = X match
  case String => Char
  case Array[t] => LeafElem[t]
  case Iterable[t] => LeafElem[t]
  case AnyVal => X

def leafElem[X](x: X): LeafElem[X] = x match
  case x: String => x.charAt(0)
  case x: Array[t] => leafElem(x(9))
  case x: Iterable[t] => leafElem(x.head)
  case x: AnyVal => x

/** Recursive match type
 *
 * ```
 * scala> type A = Concat[(String, Int), (Long, Double)]
 * defined alias type A = (String, Int, Long, Double)
 * ```
 */
type Concat[Xs <: Tuple, +Ys <: Tuple] <: Tuple = Xs match
  case EmptyTuple => Ys
  case x *: xs => x *: Concat[xs, Ys]

