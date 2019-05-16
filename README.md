# springboot-couchbase-crud

How to run:

1. Run couchbase
2. Run application with command <code>mvn spring-boot</code>:

Rest End-Points:

1. Add blog<br>
  <code>localhost:8080/blogs</code>
  Request Body:
  {
      "id": "98d09485-f75b-4c74-ac73-5d9fb7bffcd3",
      "topic": "spring-couch",
      "author": "shivangi",
      "tags": ["springboot", "couchbase"]
  }

2. Get Blog By Id<br>
  <code>localhost:8080/blogs/98d09485-f75b-4c74-ac73-5d9fb7bffcd3</code>
  
3. Delete By Id<br>
  <code>localhost:8080/blogs/id/98d09485-f75b-4c74-ac73-5d9fb7bffcd3</code>
