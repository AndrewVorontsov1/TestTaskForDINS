package withbinarytree

abstract class MySet[T] {
  def add(x: T): ImmutableSet[T]

  def toList(root: MySet[T] = this, traversal: List[T] = Nil): List[T]
}

case class Empty[T]() extends MySet[T] {
  override def add(x: T): ImmutableSet[T] = ImmutableSet(x, Empty(), Empty())

  override def toList(root: MySet[T] = this, traversal: List[T] = Nil): List[T] = Nil
}

case class ImmutableSet[T](elem: T, left: MySet[T] = Empty[T](), right: MySet[T] = Empty[T]()) extends MySet[T] {
  override def toList(tree: MySet[T] = this, traversal: List[T] = Nil): List[T] = {
    tree match {
      case Empty() => List()
      case ImmutableSet(elem, left, right) => traversal ::: List(elem) ::: toList(left, traversal) ::: toList(right, traversal)
    }
  }

  override def add(x: T): ImmutableSet[T] = {
    if (x.hashCode() < elem.hashCode()) ImmutableSet(elem, left add x, right)
    else if (x.hashCode() > elem.hashCode()) ImmutableSet(elem, left, right add x)
    else this
  }
}
