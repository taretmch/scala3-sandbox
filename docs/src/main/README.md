# Scala3 Sandbox

Scala 3 の練習用プロジェクト

## 基礎的な基盤

- 合併型 (intersection type)
- 直和型 (union type)
- ラムダ型 (type lambdas)
- Context functions

## 簡素化

- トレイトのパラメータ
- Given インスタンス
  - implicit object, implicit def の代替
- Using 句
  - implicit parameter の代替
- 拡張メソッド
  - implicit class の代替
- Opaque Type Aliases
  - Newtype
- Top-level definition
  - パッケージオブジェクトの代替
- Export 句
- Vararg Splices
  - `xs: _*` と `xs @ _*` の代替
- 普遍的な apply メソッド
  - `new` の代替

## 制約

- Implicit Conversion
  - Implicit conversion の方法は1つだけとなった
- Given インポート
  - implicits の新しい形式
- Type Projection
  - クラスだけが `C#A` という記法を使えるように。抽象型に対しては使えなくなる予定
- Multiversal Equality
- infix

## 削除された構造

- DelayedInit トレイト
  - App クラスが継承しているもの
- 手続き型の文法 `def f() { ... }` は使えなくなった
- XML リテラル
  - [XML 文字列補間](https://github.com/lampepfl/xml-interpolator) を使用する
- Symbol リテラル
- 自動適用
  - `xs.toString.length` はエラーになり、 `xs.toString().length()` とする必要がある

