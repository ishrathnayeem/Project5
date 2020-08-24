import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

trait Staging {
  val s3client: AmazonS3 = AmazonS3ClientBuilder
    .standard()
    //.withCredentials(new AWSStaticCredentialsProvider(credentials))
    .withRegion(Regions.US_EAST_1)
    .build()
}
