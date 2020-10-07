package lab1

import org.scalatest.FunSuite

class Lab1Test extends FunSuite {
    //Classes.scala

    test("Animal.apply creates animal if valid parameter is passed") {
        assert(Animal.apply("cat") == (Some(Animal.cat)))
        assert(Animal.apply("parrot") == (Some(Animal.parrot)))
        assert(Animal.apply("goldfish") == (Some(Animal.goldfish)))
    }
    test("Animal.apply returns None if wrong parameter is passed") {
        assert(Animal.apply("wrongParam") == None)
    }

    test("KnownAnimal returns true if valid animal is passed") {
        assert(Animal.knownAnimal("cat") && Animal.knownAnimal("parrot") &&
          Animal.knownAnimal("goldfish") == true)
    }

    test("KnownAnimal returns false if invalid animal is passed") {
        assert(Animal.knownAnimal("tiger") == false)
    }
    test("Animal.eats checks if animal eats given food") {
    val lion = Mammals ("lion", "meat")
    assert (lion.eats ("meat") == true)
    assert (lion.eats ("plants") == false)
    }

// Functions.scala
    test("Functions.scala testCircle calls circleArea with given radius") {
        val testCircle = Functions.testCircle(2.0)
        assert(testCircle == 12.566370614359172)
    }
    test("Functions.scala testRectangleCurried calculates area of the given rectangle") {
        val testRectangleCurried = Functions.testRectangleCurried(3, 2);
        assert(testRectangleCurried == 6)
    }
    test("Functions.scala testRectangleUc calls RectangleArea with given parameters") {
        val testRectangleUc = Functions.testRectangleUc(3, 2);
        assert(testRectangleUc == 6)
    }


// HiOrder.scala

    test("HiOrder.scala testNTimes multiplies function result by n") {
        val testNTimes = HiOrder.testNTimes(HiOrder.plus, 7, 9, 3)
        assert(testNTimes == 48)
    }
    test("HiOrder.scala testAnonymousNTimes calls nTimes with given parameters and hardcoded function") {
        val testAnonymousNTimes = HiOrder.testAnonymousNTimes(7, 9, 2)
        assert(testAnonymousNTimes == 18)
    }

// Patterns.scala
    test("Patterns.scala testIntToString recognizes numbers from 1 to 3 inclusively") {
        val testIntToString = PatternMatching.testIntToString(3)
        assert(testIntToString == "it is three")
        val testIntToString2 = PatternMatching.testIntToString(2)
        assert(testIntToString2 == "it is two")
        val testIntToString3 = PatternMatching.testIntToString(3)
        assert(testIntToString3 == "it is three")
        val testIntToString4 = PatternMatching.testIntToString(5)
        assert(testIntToString4 == "what's that")
    }
    test("Patterns.scala testIsMaxAndMoritz recognizes (M)max and (M)moritz") {
        val testIsMaxAndMoritz = PatternMatching.testIsMaxAndMoritz("Moritez")
        assert(testIsMaxAndMoritz == false)
        val testIsMaxAndMoritz2 = PatternMatching.testIsMaxAndMoritz("Max")
        assert(testIsMaxAndMoritz2 == true)
    }
    test("Patterns.scala testIsEven calls isEven with given parameter") {
        val testIsEven = PatternMatching.testIsEven(10)
        assert(testIsEven == true)
        val testIsEven2 = PatternMatching.testIsEven(5)
        assert(testIsEven2 == false)
    }
    test("Patterns.scala testWinsA calls winsA with given parameters") {
        val winsA = PatternMatching.testWinsA(PatternMatching.Paper,PatternMatching.Rock)
        assert(winsA == PatternMatching.Win)
        val winsA2 = PatternMatching.testWinsA(PatternMatching.Rock,PatternMatching.Scissor)
        assert(winsA2 == PatternMatching.Win)
        val winsA3 = PatternMatching.testWinsA(PatternMatching.Scissor,PatternMatching.Paper)
        assert(winsA3 == PatternMatching.Win)
    }
    test("Patterns.scala testExtractMammalWeight calls extractMammalWeight with given parameter") {
        val food = PatternMatching.Vegetables
        val mammal = new PatternMatching.Mammal("cat", food, 50)
        val testExtractMammalWeight = PatternMatching.testExtractMammalWeight(mammal)
        assert(testExtractMammalWeight == 50)
    }
    test("Patterns.scala testUpdateFood calls updateFood with given parameter") {
        val plants = PatternMatching.Plants

        val food = PatternMatching.Vegetables

        val fish = new PatternMatching.Fish("fish", food);
        val testUpdateFood = PatternMatching.testUpdateFood(fish)
        assert(testUpdateFood.food == plants)

        val bird = new PatternMatching.Bird("fish", food);
        val testUpdateFood2 = PatternMatching.testUpdateFood(bird)
        assert(testUpdateFood2.food == plants)
    }
}