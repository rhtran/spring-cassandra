# GUMBY - Global User Manager by Ytel

## Goals

Create API for both internal & external to manage their user's roles & privileges.

## Frameworks

1. Java 8
2. Spring Boot 1.5.7
3. Mapstruct (Object Mapper)
4. JWT Token library - 0.7.0
5. Spring Test
6. Gradle 4.3

## Datastore
1. Cassandra 2.x

## Grant types
* Authorization code grant
* Implicit grant
* Resource owner credentials grant
* Client credentials grant
* Refresh token grant

## Swagger 2 documents
/swagger-ui.html
You would see all api documents and try it out.

## Endpoints

**Account info**

| Path                                | Method | Description                        | Response                  |Done|
|-------------------------------------|--------|------------------------------------|---------------------------|----|
| /v1/gums/accounts/{id}              | GET    | get account by id                  | Account json object          | Y |
| /v1/gums/accounts?accounts=         | GET    | get accounts by account list       | List of accounts json object  | N |
| /v1/gums/accounts/{id}              | PUT    | update account info by id          |   |    ||
| /v1/gums/accounts                   | POST   | add account info          |   |    ||
| /v1/gums/accounts/{id}              | DELETE | delete account by id               |   | ||





**User info**

| Path                                | Method | Description                        | Response                  |
|-------------------------------------|--------|------------------------------------|---------------------------|
| /v1/gums/users/{id}                 | GET    | get user by username               | User json object          |
| /v1/gums/users?users=               | GET    | get users by username list          | List of user json object  |
| /v1/gums/users/{id}                 | PUT    | update user info by username       |   |    
| /v1/gums/users/{id}                 | DELETE | delete privilege by id             |   |
| /v1/gums/users/usernames/{username} | GET    | get user by username               | User json object          |
| /v1/gums/users/usernames?usernames= | GET    | get user by username list          | List of user json object  |
| /v1/gums/users             | POST   | add new user                       |   |



| Method | URI                                |
|--------|---------------------------------   |
| GET    |/v1/gums/users/uaa::acct-admin      |
| PUT    |/v1/gums/users/uaa::ytel-admin      |
| DELETE |/v1/gums/users/uaa::support-level-1 |
| POST   |                                    |


**Role info**

| Method | URI                                |
|--------|---------------------------------   |
| GET    |/v1/gums/roles/uaa::acct-admin      |
| PUT    |/v1/gums/roles/uaa::ytel-admin      |
| DELETE |/v1/gums/roles/uaa::support-level-1 |
| POST   |                                    |
| GET    |/v1/gums/roles/all                  |




**Privilege info**

| Path                             | Method | Description                        | Response                  |
|----------------------------------|--------|------------------------------------|---------------------------|
| /v1/gums/privileges/{id}         | GET    | get privilege by id                | Privilege json object           |
| /v1/gums/privileges?ids=         | GET    | get privilege by id list           | Privilege json object           |
| /v1/gums/privileges/{id}         | PUT    | update priviege info by id         |   |    
| /v1/gums/privileges/{id}         | DELETE | delete privilege by id             |   |
| /v1/gums/privileges              | POST   | add new privilege                  |   |
| /v1/gums/privileges/all          | GET    | retrieve all privilege             |   |
| /v1/gums/privileges/names/{name} | GET    | get privilege by name              |   |

## Sample requests

| Method | URI                             | Sample                               |
|--------|---------------------------------|--------------------------------------|
| GET    |/v1/gums/privileges/{id}         |/v1/gums/privileges/uaa::beacon       |
| PUT    |/v1/gums/privileges/{id}         |/v1/gums/privileges/uaa::leadbeam|
| DELETE |/v1/gums/privileges/{id}         |/v1/gums/privileges/uaa::testing |
| POST   |/v1/gums/privileges              |/v1/gums/privileges              |
| GET    |/v1/gums/privileges/all          |   |
| GET    |/v1/gums/privileges/names/{name} |   |
| GET    |/v1/gums/privileges/names?name=  |   |



**SSL Configuration on Spring Boot Application**

1. Create Java Key Store with certificate
keytool -genkey -keyalg RSA -alias selfsigned -keystore ${DEST_PATH}/keystore.jks -storepass ${PASS_WORD} -validity 360 -keysize 2048
2. List out the details of the given keystore
keytool -v -list -keystore ${PATH_TO_KEYSTORE}/keystore.jks
3. Export self-signed certificate if you want to distribute to the clients.
keytool -exportcert -rfc -alias selfsigned -keystore ${DEST_PATH}/keystore.jks -file ${DEST_PATH}/selfsigned.crt
4. Verify the certificate
keytool -printcert -file ${PATH_TO_CERTIFCATE}/selfsigned.crt


Store JWT in the header
Authorization: Bearer <your token>
i.e.
Authorization: Bearer eyJhbGciOiJIUzI1NiIXVCJ9...TJVA95OrM7E20RMHrHDcEfxjoYZgeFONFh7HgQ



