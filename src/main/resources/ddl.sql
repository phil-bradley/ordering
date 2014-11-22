
create table country (
    id serial,
    version int,
    isocode char(2),
    name varchar(255),
    printablename varchar(255),
    iso3 char(3),
    numcode int
);
