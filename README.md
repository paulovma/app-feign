# app-feign


This is an application which its intention is to simply show how to use Spring Cloud Feign.

In this example, the 'app-feigh' application consumes another application by using Spring Cloud Feign.
I also created an Interceptor which is responsible for getting the token and putting it on the request header.
*I still haven't implemented the storing of this token*

The 'app-feign' expects this application to be configured like following:
  - localhost
  - port 8080
  
You can easily change it by changing the following path in application.yaml:
  - city-webservice.url
  
The 'app-feign' also expects the following endpoints in this other application:
  - city/{cityId}
  - public/auth?username={username}&password={password}
  

