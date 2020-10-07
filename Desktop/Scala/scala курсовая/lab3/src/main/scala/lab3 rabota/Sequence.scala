package lab3

import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
 *
 * Seq(1, 2) match {
 *   case head +: tail => ???
 *   case Nil          => ???
 *   case s            => ???
 * }
 *
 * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
 */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence {

  /* a) Найдите последний элемент Seq.
   *
   */
  def testLastElement[A](seq: Seq[A]): Option[A] = seq match {
    case Seq(x) => Option[A](x)
    case head +: tail => testLastElement(tail)
  }
  

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
   *
   */
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = {
    def loop[A](a: Seq[A], b: Seq[A], c: Seq[(A, A)]): Seq[(A, A)] = a match {
      case ahead +: atail => b match {
        case blast +: Nil => c :+ (ahead, blast)
        case bhead +: btail =>loop(atail, btail, c :+ (ahead,bhead))
      }
      case Nil => c
    }
    loop(a, b, Nil)
  }

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    def loop[A](a: Seq[A])(cond: A => Boolean): Boolean = a match {
      case head +: tail => if (cond(head)) loop(tail)(cond)
      else
        false
      case Nil => true
    }
    loop(seq)(cond)
  }

  /* d) Проверьте, является ли Seq палиндромом
   *
   */
  def testPalindrom[A](seq: Seq[A]): Boolean = {
    def loop[A](a: Seq[A], b: Seq[A]): Boolean = {
      a match {
        case head +: tail => loop(tail, b = head +: b)
        case Nil => seq.equals(b)
      }
    }
    loop(seq, Nil)
  }

  /* e) Реализуйте flatMap используя foldLeft.
   *
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =
    seq.foldLeft[Seq[B]](Seq())((acc, elem) => acc ++: f(elem) )

}
