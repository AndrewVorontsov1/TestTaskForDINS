import org.scalatest.funsuite.AnyFunSuite
import withbinarytree.{MySet, ImmutableSet}

class TestSuite extends AnyFunSuite {

  trait TestSets {
    val tree: MySet[List[Int]] = ImmutableSet(List(1)) add List(1, 2) add List() add List() add List(1, 2) add List(1, 2, 3) add List(1, 2, 3)
    val tree1: MySet[String] = ImmutableSet("Привет!") add "Как дела?" add "Привет!" add "Тестирую" add "Тестирую" add "множество"
    val tree2: MySet[Int] = ImmutableSet(0) add 1 add 2 add 3 add 4 add 5 add 6 add 5 add 4 add 3 add 2 add 1 add 0

    test("Insert String test") {
      new TestSets {
        assert(tree1.toList() === List("Привет!", "Как дела?", "множество", "Тестирую"))
      }
    }
    test("Insert List test") {
      new TestSets {
        assert(tree.toList() === List(List(1), List(1, 2), List(), List(1, 2, 3)))
      }
    }
    test("Insert Int test") {
      new TestSets {
        assert(tree2.toList() === List.range(0, 7))
      }
    }
  }

}