
# Project launch:Linc to swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config/

##############################################################################

#to create system user 
#or system-controller in swagger
http://localhost:8080/system/add
# email = "1_USER@email.com"
# password = "password"

##############################################################################

#to create custom user
#or registration-controller in swagger
http://localhost:8080/api/registration
#{
#"email": "string",
#"password": "string",
#"role": "string"
#}
# password must contain numbers, small and big letters

##############################################################################

### to use the endpoints, you need to transfer a JWT token
### Headers-> authorisation 
#To search by address and save coordinates(latitude,longitude) in H2 DB or any Persistence Db
GET http://localhost:8080/api/nominatim/findCoordinatesByAddress/{{address}}

#To get all addresses by coordinates that have been stored in DB.
GET http://localhost:8080/api/nominatim/getDataFromCoordinatesBD/{{lat}}/{{lon}}

#The application must be called by REST API for receiving all addresses from Nominatim API  by saved coordinates.
GET http://localhost:8080/api/nominatim/getDataFromCoordinatesFromAPI/{{lat}}/{{lon}}

# if you want to use docker change settings in application.properties
# or dev branch
mvn clean package -DskipTests
docker build .

   
