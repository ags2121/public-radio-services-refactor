# public-radio-services-refactor

## Local development
- App was generated from:
```bash
lein new luminus public-radio-services +service +postgres
```

- create local dev postgres db:
```bash
docker pull postgres && \
docker run -d -p 5432:5432 --rm \
  --name public-radio-services-db \
  postgres
```

- to test standalone JAR locally:
```bash
lein uberjar
export DATABASE_URL=postgresql://localhost/postgres?user=postgres
java -jar target/uberjar/public-radio-services.jar
# in another terminal window
tail -f log/public-radio-services.log
```

- to test Docker locally:
```bash
lein uberjar
docker build -t public-radio-services .
docker run \
  --name public-radio-services-run \
  -e DATABASE_URL=postgresql://localhost/postgres?user=postgres \
  -p 3000:3000 \
  --link public-radio-services-db \
  -i --rm \
  public-radio-services
# in another terminal window  
docker exec -it public-radio-services-run tail -f log/public-radio-services.log
```

## Deployment
- Create a Digital Ocean Droplet using the [Docker One-Click Application](https://www.digitalocean.com/docs/one-clicks/docker/)
- Set up access to that machine up and ssh to it
- Start a postgres image
```bash
docker run --name db -e POSTGRES_PASSWORD=YOUR_PASSWORD -d postgres
```

# About
generated using Luminus version "3.10.27"

FIXME

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run

## License

Copyright © 2018 FIXME
