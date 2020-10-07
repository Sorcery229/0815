package lab3

import org.scalatest.FunSuite
import scala.util.{Failure, Success, Try}

class Lab3Test extends FunSuite {
// String.scala
    test("String.scala testUppercase returns string with all capital letters") {
        assert(Strings.testUppercase("TestString") == "TESTSTRING")
    }
    test("String.scala testInterpolations inserts given name and age into string") {
        val testInterpolations = Strings.testInterpolations("Grisha", 20)
        val result = "Hi my name is Grisha and I am 20 years old."
        assert(testInterpolations == result)
    }
    test("String.scala testComputation inserts numbers into string") {
        val testComputation = Strings.testComputation(100, 200)
        val result = "Hi, \n now follows a quite hard calculation. We try ta add: \n\ta := 100 \n\tb := 200\n\n\tresult is 300"
        assert(testComputation == result)
    }
    test("String.scala testTakeTwo takes first two characters of the string") {
        val testTakeTwo = Strings.testTakeTwo("абвгд")
        val result = "аб"
        assert(testTakeTwo == result)
    }


// Sequence.scala
    test("Sequence.scala testLastElement returns last element of the sequence") {
        val seq = Seq[Int](1, 2, 3)
        val testLastElement = Sequence.testLastElement(seq)
        val result = Option[Int](3)
        assert(testLastElement == result)
    }
    test("Sequence.scala testZip zips combines two sequences") {
        val testZip = Sequence.testZip(Seq[Int](1, 2), Seq[Int](3, 4))
        val result = Seq((1, 3), (2, 4))
        assert(testZip == result)
    }
    test("Sequence.scala testForAll checks codition for all elements") {
        val cond: Int => Boolean = _ % 2 == 0
        val testForAll = Sequence.testForAll(Seq(1, 2))(cond)
        val result = false
        assert(testForAll == result)
    }
    test("Sequence.scala testPalindrom returns true if sequence is palindrom and false otherwise") {
        val testPalindrom = Sequence.testPalindrom(Seq(2, 5, 5, 2))
        val result = true
        assert(testPalindrom == result)
    }
    test("Sequence.scala testFlatMap should apply function to each element of the sequence") {
        val seq = Seq(1,(5, 2),3,4)
        val func = (value: Any) => Seq(Seq(value))
        val testFlatMap = Sequence.testFlatMap(seq)(func)
        val result = Seq(Seq(1), Seq((5, 2)), Seq(3), Seq(4))
        assert(testFlatMap == result)
    }


// Maps.scala
    test("Maps.scala testGroupUsers should group users by name and calculate average age of each group") {
        val users = Seq(Maps.User("Grisha", 19), Maps.User("Van", 18), Maps.User("Ilya", 30))
        val testGroupUsers = Maps.testGroupUsers(users)
        val result = Map("Ilya" -> 22, "Grisha" -> 22, "Van" -> 22)
        assert(testGroupUsers == result)
    }
    test("Maps.scala testNumberFrodos counts Adam count in passed map[String->User]") {
        val users = Map("1" -> Maps.User("Adamas", 20),
            "2" -> Maps.User("Erik", 19), "3" -> Maps.User("Adam", 20))
        val testNumberFrodos = Maps.testNumberFrodos(users)
        val result = 2
        assert(testNumberFrodos == result)
    }
    test("Maps.scala testUnderaged removes from the map all users under 35 years old") {
        val users = Map("1" -> Maps.User("Ivan", 36),
            "2" -> Maps.User("", 19), "3" -> Maps.User("Lol", 40))
        val testUnderaged = Maps.testUnderaged(users)
        val result = Map("1" -> Maps.User("Ivan", 36),
            "3" -> Maps.User("Lol", 40))
        assert(testUnderaged == result)
    }


// Adts.scala
    test("Adts.scala testGetNth  should return n-th element of the list") {
        val testGetNth = Adts.testGetNth(List(1, 2, 3, 4), 2)
        val result = Option(3)
        assert(testGetNth == result)
        
        val testGetNth2 = Adts.testGetNth(Nil, 2)
        val result2 = null
        assert(testGetNth2 == result2)
    }
    test("Adts.scala testDouble should return double number and None if None is passed") {
        val testDouble = Adts.testDouble(Option(5))
        val result = Option(10)
        assert(testDouble == result)

        val testDouble2 = Adts.testDouble(None)
        val result2 = null
        assert(testDouble2 == result2)
    }
    test("Adts.scala testIsEven should return passed number if it's even and string Odd number otherwise") {
        val testIsEven = Adts.testIsEven(5)
        val result = Left("Нечетное число")
        assert(testIsEven == result)
    }
    test("Adts.scala testSafeDivide should divide two numbers unless divisor is 0") {
        val testSafeDivide = Adts.testSafeDivide(10, 2)
        val result = Right(5)
        assert(testSafeDivide == result)
        
        val testSafeDivide2 = Adts.testSafeDivide(9, 0)
        val result2 = Left("Вы не можете делить на ноль")
        assert(testSafeDivide2 == result2)
    }
    test("Adts.scala testGoodOldJava should return Try[Int]") {
        val string = "test"
        val func = (s:String) => s.size
        val result = Success(4)
        val goodOldJava = Adts.testGoodOldJava(func, string)
        assert(goodOldJava == result)
    }
}