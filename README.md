# Cache Control Demo

This Maven module demonstrates ResponseEntity cache control headers being appended to the
Spring Security headers when I would expect the controller-provided headers to take
precedence.

Run the following command to start the demo:
```
./mvnw spring-boot:run
```

Then point your browser to http://localhost:8080/swagger-ui.html and provide the
credentials ( username: user, password: none ).

Navigate to the /demo operation and click "Try it out!"

The Response Headers will show a very confused Cache-control response header.
