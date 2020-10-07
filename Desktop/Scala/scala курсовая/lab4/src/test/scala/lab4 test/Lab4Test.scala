package lab4

import org.scalatest.FunSuite

class Lab4Test extends FunSuite {
    test("Typeclasses.scala ReversableString should return reversed string") {
        val string = "Perl"
        val result = "lreP"
        val reversableString = Typeclasses.testReversableString(string)
        assert(reversableString == result)
    }
    test("Typeclasses.scala SmashInt should add integer numbers") {
        val a = 3
        val b = 4
        val result = 7
        val smashInt = Typeclasses.testSmashInt(a, b)
        assert(smashInt == result)
    }
    test("Typeclasses.scala SmashDouble should multiply double numbers") {
        val a = 3
        val b = 4
        val result = 12
        val smashDouble = Typeclasses.testSmashDouble(a, b)
        assert(smashDouble == result)
    }
    test("Typeclasses.scala SmashString should concatenate strings") {
        val a = "Lol"
        val b = "kek"
        val result = "Lolkek"
        val smashString = Typeclasses.testSmashString(a, b)
        assert(smashString == result)
    }
}