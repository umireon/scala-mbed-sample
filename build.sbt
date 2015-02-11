libraryDependencies += "com.github.jodersky" %% "flow" % "2.1.0"
libraryDependencies += "com.github.jodersky" % "flow-native" % "2.1.0"

lazy val root = (project in file("src/main")).
  settings(
    name := "hello",
    version := "1.0"
  )
