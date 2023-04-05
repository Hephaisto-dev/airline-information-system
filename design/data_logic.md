# USE CASES

---

<!-- TOC -->
- [Database_tables]()
    - [AirplaneData](#table-airplanedata)
    - [AirportData](#table-airportdata)
    - [CustomerData](#table-customerdata)
    - [RouteData](#table-routedata)
    - [FlightData](#table-flightdata)
    
                      
---

### Table AirplaneData  

```sql
create table AirplaneData
(
    id       varchar not null,
    name     varchar not null,
    capacity int,
    primary key (id)
);
```                 
---

### Table AirportData 

```sql
create table Airport(
    id      int     not null,
    name    varchar not null,
    city    varchar not null,
    country varchar not null,
    primary key (id)
);
ALTER TABLE airport
    ALTER COLUMN id TYPE varchar;
```
                      
---

### Table CustomerData

```sql
create table CustomerData(
    id        int     not null,
    firstName varchar not null,
    lastName  varchar not null,
    dob       date    not null,
    primary key (id)
);

ALTER TABLE customerdata
    ALTER COLUMN id TYPE varchar;
```                  
---

### Table RouteData

```sql
create table RouteData(
    id    varchar not null,
    fromm varchar not null,
    too   varchar not null,
    primary key (id),
    foreign key (id) references flightdata (id)
);
```
---

### Table FlightData

```sql
create table FlightData(
    id               varchar not null,
    routeDataFrom    varchar not null,
    routeDataToo     varchar not null,
    etdDateTime      varchar not null,
    etaDateTime      varchar not null,
    flightDuration   int     not null,
    airplaneID       varchar not null,
    airplaneName     varchar not null,
    airplaneCapacity int     not null,
    primary key (id)
);
```

