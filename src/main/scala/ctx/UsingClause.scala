package com.criceta.scala3.sandbox.ctx

/** Using Clauses allow you to specify parameters that,
 *
 *  at the call site, can be omitted by the programmer
 *  and should be automatically provided by the context.
 *  https://docs.scala-lang.org/scala3/book/ca-given-using-clauses.html
 */
case class Config(port: Int, baseUrl: String)
val config = Config(8080, "com.criceta")
  
/** In scala 2,
 *
 * def renderWebsite(path: String)(implicit c: Config) = ???
 */
def renderWebsite(path: String)(using Config): String =
  "<html>" + renderWidget(List("cart")) + "</html>"

def renderWidget(items: List[String])(using c: Config): String =
  s"${c.baseUrl}:${c.port}/" + items.mkString("/")

object UsingClauses:
  def run(): Unit =
    println(renderWebsite("/home")(using config))

/** Given Instances let you define terms
 *
 *  that can be used by the Scala compiler
 *  to fill in the missing arguments.
 */
object GivenInstances:
  /** Single canonical value for `Config` type */
  given Config = config
  def run(): Unit =
    println(renderWebsite("/home"))
