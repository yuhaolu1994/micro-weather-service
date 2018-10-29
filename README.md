# micro-weather-service
> To improve server efficiency by micro-services architecture. 

This application is generated using [Spring Boot 2.0.6.RELEASE](https://spring.io/projects/spring-boot) 
and [Spring Cloud Finchley.SR2](http://projects.spring.io/spring-cloud/).

## Development
Before you can build this project, you must install and configure the following dependencies on your machine:
1. [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): 
use java to run the complied .jar file.
2. [Gradle](https://gradle.org): use Gradle to manage Spring dependencies.

Run the following commands in each separate terminal of 5 different branches (micro-services)

    ./gradlew
    cd build/libs
    java -jar your_package_name.jar --server.port=port_number

Pay attention to the order of running the instance of 5 micro-services on different ports.
1. [micro-weather-eureka-server](https://github.com/yuhaolu1994/micro-weather-service/tree/micro-weather-eureka-server)
2. [msa-weather-city-eureka](https://github.com/yuhaolu1994/micro-weather-service/tree/msa-weather-city-eureka)
3. [msa-weather-collection-eureka-feign](https://github.com/yuhaolu1994/micro-weather-service/tree/msa-weather-collection-eureka-feign)
4. [msa-weather-data-eureka](https://github.com/yuhaolu1994/micro-weather-service/tree/msa-weather-data-eureka)
5. [msa-weather-eureka-client-zuul](https://github.com/yuhaolu1994/micro-weather-service/tree/msa-weather-eureka-client-zuul)
6. [msa-weather-report-eureka-feign-gateway-hystrix](https://github.com/yuhaolu1994/micro-weather-service/tree/msa-weather-report-eureka-feign-gateway-hystrix)

Check the client instance on the Eureka server.

![](https://github.com/yuhaolu1994/micro-weather-service/blob/master/src/main/resources/eureka_clients.png)

## Architecture

![](https://github.com/yuhaolu1994/micro-weather-service/blob/master/src/main/resources/architecture.png)

## Technology
### Front End
- Bootstrap
- Thymeleaf
- jQuery

### Back End
- Spring Boot
- Spring Cloud
- Spring MVC
- Apache HttpClient
- Quartz Scheduler

### Micro Service Managment
- Eureka
- OpenFeign
- Zuul
- Hystrix

### Data Processing
- XmlBuilder.xmlStrToObject
- restTemplate.getForEntity
- stringRedisTemplate.opsForValue
