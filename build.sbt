name := "course5"

version := "0.1"

scalaVersion := "2.12.8"
// https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-s3
libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.11.846"
// https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-athena
libraryDependencies += "com.amazonaws" % "aws-java-sdk-athena" % "1.11.846"
// https://mvnrepository.com/artifact/com.syncron.amazonaws/simba-athena-jdbc-driver
libraryDependencies += "com.syncron.amazonaws" % "simba-athena-jdbc-driver" % "2.0.2"