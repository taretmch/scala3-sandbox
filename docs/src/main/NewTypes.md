# New Types

## 合併型 (intersection type)

- `&` 演算子は合併型を作る。
- 型 `A & B` は、`A` と `B` どちらの型のメソッドも持つ。
- `&` は交換法則を満たす。 `A & B` は `B & A` に等しい。

## 直和型 (union type)

- `|` 演算子は直和型を作る。

```scala
scala> val name = UserName("hoge")
val name: com.criceta.scala3.sandbox.types.UserName = UserName(hoge)

scala> val pass = Password(User.Hash("fuga"))
val pass: com.criceta.scala3.sandbox.types.Password = Password(fuga)

scala> val either = if true then name else pass
val either: Object = UserName(hoge)

scala> val either: Password | UserName = if true then name else pass
val either: com.criceta.scala3.sandbox.types.Password |
  com.criceta.scala3.sandbox.types.UserName = UserName(hoge)
```
