
## Goals

Implement movie list API using Spring Boot & Cassandra.

## Frameworks & Libraries

1. Java 8
2. Spring Boot 2.2.5
3. Mapstruct (Object Mapper)
5. Spring Test
6. Gradle 6.x

## Datastore
1. Cassandra 3.x

## Brief Cassandra Intro
primary key, composite/compound key, partition key, and clustering key

_Simple example_\
`
CREATE TABLE movie (
  id TEXT PRIMARY KEY,
  year INTEGER,
  title TEXT,
  genre TEXT,
  synposis TEXT
)
`

_Primary key can be Composite_

`CREATE TABLE movie (
  id TEXT,
  year INTEGER,
  genre TEXT,
  title TEXT,
  synposis TEXT,
  PRIMARY KEY(year, genre)
)
`

year is the PARTITION KEY \
genre is the CLUSTERING KEY

Both partition and clustering key can be made by 1 or more columns.


`CREATE TABLE movie (
  id TEXT,
  title TEXT,
  year INTEGER,
  genre TEXT,
  synposis TEXT,
  PRIMARY KEY((year, genre), title)
)
`

In summary:
* primary key uniquely identifies/locates a row
* composite key is a key formed multiple columns
* partition key is the lookup to find a set of rows
* clustering key defines the ordering within a partition


## Endpoints

**Movie**

| Path                          | Method | Description                      | Response                   |
|-------------------------------|--------|----------------------------------|----------------------------|
| /v1/sc/movies/{id}            | GET    | get movie by id                  | Movie json object          | 
| /v1/sc/movies?movies=         | GET    | get movies by movie id list      | List of movies json object | 
| /v1/sc/movies                 |        |                                  |                            | 

**Actor**

| Path                          | Method | Description                      | Response                   |
|-------------------------------|--------|----------------------------------|----------------------------|
| /v1/sc/actors/{id}            | GET    | get actor by id                  | Actor json object          | 
| /v1/sc/actors?actors=         | GET    | get actors by movide list        | List of actors json object | 
| /v1/sc/actors                 |        |                                  |                            |




