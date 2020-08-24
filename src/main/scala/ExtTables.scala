
class ExtTables extends Staging {
  def CreateTables() {
    stmt execute """DROP TABLE IF EXISTS ext_trips"""
    stmt execute """DROP TABLE IF EXISTS ext_frequencies"""
    stmt execute """DROP TABLE IF EXISTS ext_calendar_dates"""
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_snehith.ext_routes (
        |`route_id` int,
        |`agency_id` string,
        |`route_short_name` int,
        |`route_long_name` string,
        |`route_type` int
        |`route_url` string,
        |`route_color` string,
        |`route_text_color` string
        |ROW FORMAT DELIMITED
        |FIELDS TERMINATED BY ','
        |STORED AS TEXTFILE
        |LOCATION 's3://course8-aws/assignment1/routes/'
        |TBLPROPERTIES (
        | "skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin

    println("ext_routess TABLE was CREATED")
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

    stmt.execute("DROP TABLE IF EXISTS fall2019_snehith.ext_calendar_dates")
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_snehith.ext_calendar_dates (
        |service_id       STRING,
        |date             INT,
        |exception_type   INT
        |)
        |ROW FORMAT DELIMITED
        |FIELDS TERMINATED BY ','
        |STORED AS TEXTFILE
        |LOCATION 's3://course8-aws/assignment1/calender_dates
        |TBLPROPERTIES (
        |"skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin

    println("ext_calendar_dates TABLE was CREATED")


  }
}