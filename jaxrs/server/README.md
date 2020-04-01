HOW TO USE
----------
mvn wildfly:start
mvn wildfly:deploy
curl http://localhost:8080/jaxrs-sample/library/books
mvn wildfly:shutdown

Note:
-----
If jboss-web.xml is missing or does not override the context root,
then the context root is being defined by the deployed artifact's name.
E.g., one would use:
curl http://localhost:8080/javaee-tutorial-jaxrs-server-1.0.0-SNAPSHOT/library/books
