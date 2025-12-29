# springboot_JPA

## 라이브러리 

- Spring Boot Devtools
- Lombok
- Spring Configuration Processor
- Spring Web
- Thymeleaf
- MySql Driver
- **Spring Data JPA**

**나중에 추가**
- log4jdbc
- thymeleaf-layout
- Querydsl JPA Support 5.0.0:jakarta
---

## DB 설정 

- DB : bootdb
- user : springuser
- password : mysql

-- 1. booddb 생성
create database bootdb;

-- 2. 유저에게 권한 부여
grant all privileges on bootdb.*to 'springuser'@'localhost';
flush privileges;

controller : BoardDAO => BoardRepository (interface)
sevice
repository
dto => 엣날 domain
entity => 테이블 mapping용 객체

DTO => 화면 
Entitiy => Mapping

---
thumbnailator 0.4.20 -> 추가

application.properties
fileupload 설정 추가

``````
dependencies {
// Querydsl 라이브러리 (JPA 연동용)
implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'

    // Querydsl QClass 생성을 위한 어노테이션 프로세서 (핵심!)
    annotationProcessor "com.querydsl:querydsl-apt:5.0.0:jakarta"

    // Java 17 및 Jakarta EE 환경에서 필요한 API들
    annotationProcessor "jakarta.annotation:jakarta.annotation-api"
    annotationProcessor "jakarta.persistence:jakarta.persistence-api"
}
```