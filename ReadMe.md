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
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createEventConfigs ($input: [EventConfigDto]) {\n    createEventConfigs (input: $input)\n}","variables":{"input":{"eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"Muralidharan"},"eventReceiverConfig":{"receiverFirstName":"Aaron","receiverLastName":"VN","birthdayInfo":{"customBirthdayWish":"Wishing you many more happy returns of the day","receiverBirthDate":"1919-12-03"}}}}}'

curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query findAllEvents {\n    findAllEvents {\n        id\n        senderFirstName\n        senderPhoneNumber\n        receiverFirstName\n        receiverPhoneNumber\n        receiverAnniversaryDate\n        receiverBirthDate\n    }\n}","variables":{}}'

curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query findEventById ($id: String) {\n    findEventById (id: $id) {\n        id\n        senderFirstName\n        senderPhoneNumber\n        receiverFirstName\n        receiverPhoneNumber\n        receiverAnniversaryDate\n        receiverBirthDate\n    }\n}","variables":{"id":"621a33a85f0f35644e62af06"}}'