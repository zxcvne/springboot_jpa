# springboot_jpa

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

