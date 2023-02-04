# TECH_U_KNOW

This is a desktop application made in Java Swings as the front end and MySQL as the backend

## MySQL Part

To deploy this project run

```bash
  mysql -u[uname] -p[passwd]

  mysql> use kc_2feb23;
  mysql> create table courses(name varchar(20), 
        -> choice varchar(10)
        -> );
```


## Compile and run

To run tests, run the following command

```bash
  javac -cp mysqljava.jar A1Test.java
```
```bash
  java -cp mysqljava.jar;. A1Test
```
