# JournalApp
Journal app created using MongoDB and spring.

## Running MongoDB database (replica) 
You can make MongoDB replica using following command:
```
mongod --port 27017 --dbpath /srv/mongodb/db0 --replSet rs0 --bind_ip localhost,<hostname(s)|ip address(es)>
```

In order to use multi-document transactions it is necessary to make replica sets (or shard clusters). These solutions are
supported since release of MongoDB version 4.0 and version 4.2 respectively.

After the first MongoDB database start it is necessary to create collections for the application named "users" and "entries" 
(Multi-document transactions does not supaport auto-creation of the collections).
It can be done using following commands:

```
db.createCollection("users")
db.createCollection("entries")
```
One can check already existing collections with the command:
```
show collections
```