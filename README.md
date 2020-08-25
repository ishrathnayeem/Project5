Objective
The objectives of this project is to Design a cloud native full batch data pipelinepreparing raw data 
for data transformation and partitioning the final data using Athena

Problem statement
We get the information of STM every day on S3 and need to run an ETL pipeline to enrich data for
reporting and analysis purpose in once a day batch job.

In this project we created a bucket and uploaded trips,calendar_dates and frequencies in to it
We created a tables using SQL Query. As Athena is limited the tables that are created in Athena are external tables by default
For Athena JDBC connection first we have to save our AWS credentials that are shown during login in our local machine by creating a file ~/.aws/credentials this is for authentication and then write the driver manager.
