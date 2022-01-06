# javaEE
A **WannaBe** Java EE Demo project

WIP

### notes

1. You can start this web app like all spring boot apps
    1. Run `mvn spring-boot:run`
    1. Run FotisApplication.java class us java application from inside an IDE
1. H2 embedded database used (see aplication.properties for setup info)
1. access embedded db client console -> http://localhost:8080/h2, username = fotis, password = vach, jdbc-url = jdbc:h2:mem:testdb
1. Auto generated ddls for create and drop tables are in "./target/create.sql" and "./target/drop.sql" relative paths
1. Access rest services api - docs in "http://localhost:8080/swagger-ui/index.html", auto generated by Swagger-UI. Json format can be found in "http://localhost:8080/v3/api-docs", or in /target/openapi.json
