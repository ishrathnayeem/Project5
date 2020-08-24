
class ExtTables extends Staging {
  def CreateTables() {
    stmt execute """DROP TABLE IF EXISTS ext_trips"""
    stmt execute """DROP TABLE IF EXISTS ext_frequencies"""
    stmt execute """DROP TABLE IF EXISTS ext_calendar_dates"""
    stmt.execute("DROP TABLE IF EXISTS fall2019_snehith.ext_trips")
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_snehith.ext_trips (
        |route_id               INT,
        |service_id             STRING,
        |trip_id                STRING,
        |trip_headsign          STRING,
        |direction_id           STRING,
        |shape_id               STRING,
        |wheelchair_accessible  STRING,
        |note_fr                STRING,
        |note_en                STRING
        |)
        |ROW FORMAT DELIMITED
        |FIELDS TERMINATED BY ','
        |STORED AS TEXTFILE
        |LOCATION 's3://course8-aws/assignment1/trips'
        |TBLPROPERTIES (
        | "skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin

    println("ext_routes TABLE was CREATED")
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_snehith.ext_calendar_dates (
        |service_id       STRING,
        |date             INT,
        |exception_type   INT
        |)
        |ROW FORMAT DELIMITED
        |FIELDS TERMINATED BY ','
        |STORED AS TEXTFILE
        |LOCATION 's3://course8-aws/assignment1/calendar_dates/'
        |TBLPROPERTIES (
        |"skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin
    println("ext_calendar_dates TABLE was CREATED\n")

    stmt.execute("DROP TABLE IF EXISTS fall2019_srujan.ext_frequencies")
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_srujan.ext_frequencies (
        |trip_id        STRING,
        |start_time     INT,
        |end_time       INT,
        |headway_secs   INT
        |)
        |ROW FORMAT DELIMITED
        |FIELDS TERMINATED BY ','
        |STORED AS TEXTFILE
        |LOCATION 's3://user/fall2019/srujan/project4/frequencies'
        |TBLPROPERTIES (
        |"skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin

    println("ext_frequencies TABLE was CREATED\n")
  }
}