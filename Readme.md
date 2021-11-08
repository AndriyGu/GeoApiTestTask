

# Project launch:Linc to swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config/

### Adminer setting for databases access:
#####  - MySQL
      Server:	mysql
      User:	        geouser
      Password:	1234
      Database:	geotest_db

mvn clean package -DskipTests

docker build .

   
