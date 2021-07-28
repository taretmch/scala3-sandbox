package com.criceta.scala3.sandbox.types

/** Union types
 *
 * http://dotty.epfl.ch/docs/reference/new-types/union-types.html
 */
case class User(
  id:   Long,
  name: String,
  hash: User.Hash
)

object User:
  opaque type Hash = String
  object Hash:
    def apply(raw: String): Hash = raw

/** List of user (mock data) */
val userSeq: Seq[User] = Seq(
  User(1, "Yamada Hanako", User.Hash("abcdefg")),
  User(2, "Tanaka Taro", User.Hash("qawsedrf")),
  User(3, "Hoge Foo", User.Hash("hogehoge"))
)

case class UserName(name: String)
case class Password(hash: User.Hash)

/** Example of union type
 *
 * Find user by id, user name or password
 *
 * ```
 * scala> help(2)
 * val res0: Option[com.criceta.scala3.sandbox.types.User] = Some(User(2,Tanaka Taro,qawsedrf))
 * 
 * scala> help(3)
 * val res1: Option[com.criceta.scala3.sandbox.types.User] = Some(User(3,Hoge Foo,hogehoge))
 * 
 * scala> help(4)
 * val res2: Option[com.criceta.scala3.sandbox.types.User] = None
 * ```
 */
def help(id: Long | UserName | Password): Option[User] =
  id match
    case id: Long       => lookupId(id)
    case UserName(name) => lookupName(name)
    case Password(hash) => lookupPassword(hash)

def lookupId(id: Long): Option[User] =
  userSeq.find(_.id == id)

def lookupName(name: String): Option[User] =
  userSeq.find(_.name == name)

def lookupPassword(hash: User.Hash): Option[User] =
  userSeq.find(_.hash == hash)
