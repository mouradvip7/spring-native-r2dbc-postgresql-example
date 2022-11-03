# spring-native-r2dbc-postgresql-example


## This is a basic sample of a spring native application

technologies used are spring-webflux, r2dbc, postgresql

## Run

### docker 
  `docker compose up -d`

execute the ressources/init.sql file in the database console

### build image
  `sh build-image.sh`

### run it
  `target/native-r2dbc`
  

### HTTP request 

`curl http://localhost:8080/api/v1/jobs/`

you should get a response containing a job at GOOGLE!


  
