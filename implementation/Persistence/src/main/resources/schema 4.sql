create table airplanes
(
    id     varchar not null,
    name   varchar not null,
    length int     not null,
    width  int     not null,
    primary key (id)
);

create table airports
(
    id      varchar not null,
    name    varchar not null,
    city    varchar not null,
    country varchar not null,
    primary key (id)
);

create table customers
(
    id         varchar not null,
    first_name varchar not null,
    last_name  varchar not null,
    dob        date    not null,
    primary key (id)
);

create table routes
(
    id    varchar not null,
    fromm varchar not null,
    too   varchar not null,
    primary key (id)
);

create table flights
(
    id              varchar not null,
    airport_from_id varchar not null,
    airport_to_id   varchar not null,
    etd_date_time   varchar not null,
    eta_date_time   varchar not null,
    flight_duration int     not null,
    airplane_id     varchar not null,
    primary key (id),
    foreign key (airplane_id) references airplanes (id),
    foreign key (airport_from_id) references airports (id),
    foreign key (airport_to_id) references airports (id)
);

create table employees
(
    id         varchar not null,
    first_name varchar not null,
    last_name  varchar not null,
    dob        date    not null,
    type_id    int     not null,
    primary key (id)
);

create table bookings
(
    id          varchar not null,
    employee_id varchar not null,
    flight_id   varchar not null,
    date        date    not null,
    primary key (id),
    foreign key (employee_id) references employees (id),
    foreign key (flight_id) references flights (id)
);

create table customers_bookings
(
    customer_id varchar not null,
    booking_id  varchar not null,
    foreign key (customer_id) references customers (id),
    foreign key (booking_id) references bookings (id)
);


create table tickets
(
    id          varchar not null,
    flight_id   varchar not null,
    customer_id varchar not null,
    price       int     not null,
    seat_id     varchar not null,
    primary key (id),
    foreign key (flight_id) references flights (id),
    foreign key (customer_id) references customers (id)
);