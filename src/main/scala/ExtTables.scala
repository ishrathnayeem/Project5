class ExtTables {
  def CreateTables() {
    stmt execute """DROP TABLE IF EXISTS ext_trips"""
    stmt execute """DROP TABLE IF EXISTS ext_frequencies"""
    stmt execute """DROP TABLE IF EXISTS ext_calendar_dates"""
    stmt execute
      """CREATE EXTERNAL TABLE fall2019_ishrath.ext_trips (
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
        |LOCATION '/user/fall2019/ishrath/project4/trips'
        |TBLPROPERTIES (
        | "skip.header.line.count" = "1",
        |"serialization.null.format" = "")""".stripMargin

    println("ext_trips TABLE was CREATED")
}
