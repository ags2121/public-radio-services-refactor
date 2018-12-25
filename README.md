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
