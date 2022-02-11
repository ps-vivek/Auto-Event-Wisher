set -e
echo '################ MONGO ENTRYPOINT START ################'

mongo -u $MONGO_INITDB_ROOT_USERNAME -p $MONGO_INITDB_ROOT_PASSWORD --authenticationDatabase $MONGO_INITDB_ROOT_DATABASE $MONGO_INITDB_DATABASE --eval "db.createUser({ user: '$MONGO_DB_USERNAME', pwd: '$MONGO_DB_PASSWORD', roles: [{ role: 'dbOwner', db: '$MONGO_INITDB_DATABASE' }] })"

echo '################ MONGO ENTRYPOINT END ################'
