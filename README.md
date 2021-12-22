## Prerequisite for running project
-JDK must be installed.\
-PostgreSQL must be installed than u should create a database named `googleapiproject3`. \
-username and password for database is `postgres`. You can change it from `src.main.resources.application.properties`. \
-You must have an `API_KEY` from google and change the `PlacesServiceImpl line 30` 

## To run the project 
-First you can run project via an IDE.\
-Or you can bootstrap project from terminal inside project directory by typing `./gradlew build` and after build finished type `java -jar ./build/libs/google-places-api-project-0.0.1-SNAPSHOT.jar`

## API Information
-This is a backend project without frontend.\
-You can use endpoints from postman.\
-Project only accepts get requests. \
-Api runs in port 8070. 

## endpoint
`-Get request: ` http://localhost:8070/?longitude={longitude}&latitude={latitude}&radius={radius} \



