import java.sql.{Connection, DriverManager, Statement}

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

trait Staging extends App {
  val s3client: AmazonS3 = AmazonS3ClientBuilder
    .standard()
    //.withCredentials(new AWSStaticCredentialsProvider(credentials))
    .withRegion(Regions.US_EAST_1)
    .build()

  val driverName: String = "com.simba.athena.jdbc.Driver"
  Class.forName(driverName)
  val connection: Connection = DriverManager
    .getConnection("jdbc:awsathena://AwsRegion=us-east-1;S3OutputLocation=s3://course8-aws/;" +
      "AwsCredentialsProviderClass=com.simba.athena.amazonaws.auth.profile.ProfileCredentialsProvider;" +
      "AwsCredentialsProviderArguments=default;")

  val stmt: Statement = connection.createStatement()
  val bucketname = "course8-aws"
  val folder= "assignment8"

  val tripsname = "assignment1/trips/"
  val frequenciesname = "assignment1/frequencies/"
  val calendar_datename = "assignment1/calendar_dates/"
  val tripfile = "assignment1/trips/trips.txt"
  val frequencyfile= "assignment1/frequenciesname/frequencies.txt"
  val calendardatesfile ="assignment1/calenda_dates/calendar_dates.txt"
  val tloc= "/home/snehith/Documents/stm/trips.txt"
  val floc ="/home/snehith/Documents/stm/frequencies.txt"
  val caloc = "//home/snehith/Documents/stm/calendar_dates.txt"
  if (s3client.doesBucketExistV2(bucketname))
  {
    println("already exist")
    s3client.deleteBucket(bucketname)
    println("deldeted")
  }

}
