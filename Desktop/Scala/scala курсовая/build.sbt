


lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.13.2",
  libraryDependencies +=
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
)

lazy val root = project
  .in(file("."))
  .aggregate(lab1, lab2, lab3, lab4)
  .settings(commonSettings)

lazy val lab1 = project
  .settings(commonSettings)

lazy val lab2 = project
  .settings(commonSettings)

lazy val lab3 = project
  .settings(commonSettings)

lazy val lab4 = project
  .settings(commonSettings)


