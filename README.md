# javaEE
A Spring Boot Demo project

WIP

### notes

1. You can start this web app like all spring boot apps
    1. Run `mvn spring-boot:run`
    1. Run FotisApplication.java class us java application from inside an IDE
    1. java -jar target/fotis-1.0-SNAPSHOT.jar, for UAT enviroment add this: --spring.profiles.active=uat --USER=fotis --PASS=vach
1. H2 embedded database used (see aplication.properties for setup info)
1. access embedded db client console -> http://localhost:8080/h2, username = fotis, password = vach, jdbc-url = jdbc:h2:mem:testdb
1. Auto generated ddls for create and drop tables are in "./target/create.sql" and "./target/drop.sql" relative paths
1. Access rest services api - docs in "http://localhost:8080/swagger-ui/index.html", auto generated by Swagger-UI. Json format can be found in "http://localhost:8080/v3/api-docs", or in /target/openapi.json
1. Run in UAT/Production target enviroment with maven with: mvn spring-boot:run -Dspring-boot.run.profiles=prod
1. Run tests with: mvn test
1. See jacoco report in path: javaEE/target/site/jacoco/index.html

### Docker 

Postgres SQL docker instructions:
1. docker pull postgres:alpine3.16
1. sudo docker create --name javaeepostgres -e POSTGRES_PASSWORD=vach -e POSTGRES_USER=fotis -p 5432:5432 postgres:alpine3.16
1. sudo docker start javaeepostgres
1. you have to run manualy the postgreSQL_db_init.sql to initialize the db.

1. Initial run docker image with : 
    * sudo docker compose up --build
    * sudo docker compose -f docker-compose-uat.yml up --build
    * sudo docker compose -f docker-compose-prod.yml up --build

#### Build and push Docker image:

1. sudo docker image build -t fotisvach/wannabejavaee:[tagVersion] .
1. sudo docker push fotisvach/wannabejavaee:[tagVersion]
