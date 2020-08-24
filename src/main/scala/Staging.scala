import java.io.{ByteArrayInputStream, File}
import java.sql.{Connection, DriverManager, Statement}

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

trait Staging extends App {
  //connecting to s3 bucket
  val s3Client: AmazonS3 = AmazonS3ClientBuilder
    .standard().withRegion(Regions.US_EAST_1).build()

  val bucketname = "course8-aws"


  val meta = new ObjectMetadata()
  meta.setContentLength(0)
  val empty = new ByteArrayInputStream(new Array[Byte](0))
  //directories in bucket
  val trips_dir = "assignment1/trips/"
  val frequencies_dir = "assignment1/frequencies/"
  val calendar_date_dir = "assignment1/calendar_dates/"
  //
  val trips_dir1 = "assignment1/trips/trips.txt"
  val frequencies_dir1 = "assignment1/frequencies/frequencies.txt"
  val calendar_date_dir1 = "assignment1/calendar_dates/calendar_dates.txt"
  // local file path
  val trips_loc = "/home/snehith/Documents/stm/trips.txt"
  val frequencies_loc = "/home/snehith/Documents/stm/frequencies.txt"
  val calender_dat_loc = "//home/snehith/Documents/stm/calendar_dates.txt"

  //creating directories in the bucket
  
  //connecting to athena
  val driverName: String = "com.simba.athena.jdbc.Driver"
  Class.forName(driverName)
  val connection: Connection = DriverManager
    .getConnection("jdbc:awsathena://AwsRegion=us-east-1;S3OutputLocation=s3://course8-aws/;" +
      "AwsCredentialsProviderClass=com.simba.athena.amazonaws.auth.profile.ProfileCredentialsProvider;" +
      "AwsCredentialsProviderArguments=default;")
  val stmt: Statement = connection.createStatement()
  def upload() {
    s3Client.putObject(bucketname,trips_dir1,new File(trips_loc))
    s3Client.putObject(bucketname,frequencies_dir1,new File(frequencies_loc))
    s3Client.putObject(bucketname,calendar_date_dir1,new File(calender_dat_loc))

  }
}
