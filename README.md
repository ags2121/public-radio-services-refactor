# public-radio-services-refactor

1. Create a Digital Ocean Droplet using the [Docker One-Click Application](https://www.digitalocean.com/docs/one-clicks/docker/)
2. Set up access to that machine up and ssh to it
3. Start a postgres image
```bash
docker run --name db -e POSTGRES_PASSWORD=YOUR_PASSWORD -d postgres
```
