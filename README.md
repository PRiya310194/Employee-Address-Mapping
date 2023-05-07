# Employee-Address-Mapping
IntelliJIDEA
* Serverport: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)

## Steps to run User Management System
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/ URL * Type endpoints in The
## Employee model will have the following details
* id
* firstName
* LastName
* address
## Address model will have the following details
* eventId;
* street
* city
* date;
* state
* zipcode

Employee will perform following operations -
### -> Add employee Info - 
In AddEmployee functionality we Post employee info through Postman and it gets added to the emplyee list -
* End point-http://localhost:8080/save
### -> Get employee Info by employeeId -
In this functionality we provide a perticular employee info by sending the employeeId in url through @Pathvariable -
* Endpoint-http://localhost:8080/ById/4
### Get all Employee Info -
This functionality provides all Employee info list -
* Endpoint- http://localhost:8080/findAll

###  Update employee  Info by employeeId-
This functionality Updates a perticular employee info through Postman by sending employeeId in url -
* Endpoint ->http://localhost:8080/update/4

###  Delete Employee Info by UserId-
This functionality deletes particular employee info through Postman using the Delete method by sending the employeeId in URL-
* Endpoint-> http://localhost:8080/delete/4

### -> Add Address Info - 
In AddAdress functionality we Post address info through Postman and it gets added to the event list -
* End point-http://localhost:8080/saveAddress

### Get all address Info -
This functionality provides all address info list -
* Endpoint- http://localhost:8080/findAllAdd

### -> Get address Info by addressId -
In this functionality we provide a perticular address info by sending the addressId in url through @Pathvariable -
* Endpoint-http://localhost:8080/findById/1

###  Delete address Info by addressId-
This functionality deletes particular User info through Postman using the Delete method by sending the user-id in URL-
* Endpoint-> http://localhost:8080/deleteAdd/1

###  Update address  Info by addressId-
This functionality Updates a perticular address info through Postman by sending addressId in url -
* Endpoint ->http://localhost:8080/updateAdd/2

## Note
* You can change server port by setting properties in application.properties file i.e.
   server.port=8081
