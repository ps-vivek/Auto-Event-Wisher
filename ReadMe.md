Docker related setup in this repo was set up based on :
https://saeidfarahi.medium.com/get-started-with-spring-boot-mongodb-and-docker-compose-cfae8283ed1b

Install docker.

Navigate to root folder of property.

Run
docker network create love-network

docker-compose --env-file ".\mongodb\.env" build

docker-compose --env-file ".\mongodb\.env" up -d


Graphql queries:
----------------
curl --location --request POST 'http://localhost:8180/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createEventConfigs ($input: [EventConfigDto]) {\n    createEventConfigs (input: $input)\n}","variables":{"input":{"eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"Muralidharan"},"eventReceiverConfig":{"receiverFirstName":"Aaron","receiverLastName":"VN","birthdayInfo":{"customBirthdayWish":"Wishing you many more happy returns of the day","receiverBirthDate":"1919-12-03"}}}}}'