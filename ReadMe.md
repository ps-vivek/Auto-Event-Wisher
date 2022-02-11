This contains code related to minor enhacements provided in the blog:
https://saeidfarahi.medium.com/get-started-with-spring-boot-mongodb-and-docker-compose-cfae8283ed1b

Install docker.

Navigate to root folder of property.

Run
docker network create love-network

docker-compose --env-file ".\mongodb\.env" build

docker-compose --env-file ".\mongodb\.env" up -d