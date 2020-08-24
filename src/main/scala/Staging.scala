import java.io.ByteArrayInputStream
import java.sql.{Connection, DriverManager, Statement}
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

trait Staging extends App {
  //connecting to s3 bucket
  val s3Client:AmazonS3 = AmazonS3ClientBuilder
    .standard().withRegion(Regions.US_EAST_1).build()

  val bucketname=""
  val filepath = "/home/ishrath/course8/"
  val folder1 ="assignment1/"

  val meta = new ObjectMetadata()
  meta.setContentLength(0)
  val empty = new ByteArrayInputStream(new Array[Byte](0))
  //directories in bucket
  val trips_dir          = "assignment1/trips/"
  val frequencies_dir    = "assignment1/frequencies/"
  val calendar_date_dir  = "assignment1/calendar_dates/"
  // local file path
  val trips_loc          = "/home/snehith/Documents/stm/trips.txt"
  val frequencies_loc    = s"/home/snehith/Documents/stm/frequencies.txt"
  val calender_dat_loc   = "//home/snehith/Documents/stm/calendar_dates.txt"

  //creating directories in the bucket
  s3Client.putObject(bucketname,folder1,empty,meta)
  def staging: Unit ={

  }
  val trips              =    s3Client.putObject(bucketname,trips_dir,empty,meta)
  val frequencies        =    s3Client.putObject(bucketname,frequencies_dir,empty,meta)
  val calendar_dates     =    s3Client.putObject(bucketname,calendar_date_dir,empty,meta)

  //connecting to athena
  val driverName: String = "com.simba.athena.jdbc.Driver"
  Class.forName(driverName)
  val connection: Connection = DriverManager
      .getConnection("jdbc:awsathena://AwsRegion=us-east-1;S3OutputLocation=s3://course8-aws/;" +
      "AwsCredentialsProviderClass=com.simba.athena.amazonaws.auth.profile.ProfileCredentialsProvider;" +
      "AwsCredentialsProviderArguments=default;")

  val stmt: Statement = connection.createStatement()
<<<<<<< HEAD

=======
  def Staging() {

    s3client.createBucket(bucketname)
    val meta = new ObjectMetadata()
    meta.setContentLength(0)
    val empty = new ByteArrayInputStream(new Array[Byte](0))
    s3client.putObject(bucketname, folder, empty, meta)
    val frequencies = s3client.putObject(bucketname, frequenciesname, empty, meta)
    val calendar_dates = s3client.putObject(bucketname, calendar_datename, empty, meta)

  }
  
>>>>>>> 352f73c7ce4774f59fa83e2e5a8d4fecf49b3594
}
