object Main extends Staging {
  s3Client.putObject(bucketname, folder1, empty, meta)
  val trips = s3Client.putObject(bucketname, trips_dir, empty, meta)
  val frequencies = s3Client.putObject(bucketname, frequencies_dir, empty, meta)
  val calendar_dates = s3Client.putObject(bucketname, calendar_date_dir, empty, meta)

  val create = new ExtTables
  create.CreateTables()
  s3Client.deleteObject(bucketname,trips_dir)
  s3Client.deleteObject(bucketname,frequencies_dir)
  s3Client.deleteObject(bucketname,calendar_date_dir)
  create.upload()

  stmt execute
    """CREATE table fall2019_snehith.enrichedTrip
      |WITH (format='PARQUET',
      |parquet_compression='SNAPPY',
      |partitioned_by=Array['wheelchair_accessible'],
      |external_location = 's3://snehithdata/2')
      |AS
      |SELECT t.route_id,t.service_id,t.trip_id,t.trip_headsign,t.direction_id,t.shape_id,
      |t.note_fr,t.note_en,f.start_time,f.end_time,f.headway_secs,c.date,c.exception_type,t.wheelchair_accessible
      |FROM ext_trips t
      |FULL OUTER JOIN fall2019_snehith.ext_calendar_dates c
      |ON t.service_id = c.service_id
      |FULL OUTER JOIN fall2019_snehith.ext_frequencies f
      |ON t.trip_id = f.trip_id""".stripMargin




}
