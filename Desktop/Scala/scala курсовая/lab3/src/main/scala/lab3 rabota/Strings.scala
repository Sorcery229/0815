/** Напишите ваши решения в тестовых функциях.
 *
 * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
 */
package lab3
object Strings {

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
   *
   */
  def testUppercase(str: String): String = str.toUpperCase()

  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.
   *
   */
  def testInterpolations(name: String, age: Int): String =
    "Hi my name is %s and I am %d years old.".format(name, age)

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *
   *         result is <a + b>
   *
   *
   */
  def testComputation(a: Int, b: Int): String =
    "Hi, \n now follows a quite hard calculation. We try ta add: \n\ta := %d \n\tb := %d\n\n\tresult is %d".format(a,b,a+b)

  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
  */
  def testTakeTwo(str: String): String = if (str.length == 2) str else str.take(2)
}
