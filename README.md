<meta charset="UTF-8">
<head><style>body {font-family: Tahoma}</style><style>h2 {background-color: #D6EBFF;}</style><style>h3 {background-color: #FFEAD6;}</style><style>table tbody tr td:nth-child(1) {background-color: #66FFCC;}</style><style>table tbody tr td:nth-child(2) {background-color: #FFD6CC;}</style></head>


# shopping-cart
This is a sample project to expose an API for Shopping cart

0. **required before start:**
   * install JDK 11
   * install maven
   * install PostgreSQL

1. **Start Project:**
   * To start project with ide like intellij ide, you should download it and install and finally open cloned code from github on it.
   * To start with Tomcat Server:
     * Install Tomcat
     * run mvn clean package command on the command prompt in root of the project
     * get war file from target folder and copy in the tomcat web server
     * start tomcat


2. **Additional part**
   * Include Swagger Documentation on port: **http://localhost:9091/swagger-ui.html**
   * Include Configuration with **CircleCI** for building process
   * Include Integration Test with h2 database

     

