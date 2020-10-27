# Spring Boot Multiple Databases
Spring Boot Multiple Databases

## DATABASE CONFIGURATION
### MARIADB
#### CREATE DATABASE AND USER (PRIMARY)
````
$mysql -u root -p
CREATE DATABASE primary_db;
CREATE USER primary_user@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON primary_db.* TO primary_user@'%';
````

#### CREATE DATABASE AND USER (SECONDARY)
````
CREATE DATABASE secondary_db;
CREATE USER secondary_user@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON secondary_db.* TO secondary_user@'%';
````

