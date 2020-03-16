# Spring Boot e-mail and file upload demo

You will need access to an SMTP server, for instance by registering for a free account with [SendGrid](https://sendgrid.com/).

Requires specific additions to `application.properties`:
```
# Settings for Spring Boot Java Mail Sender
spring.mail.host=[YOUR SMTP SERVER]
spring.mail.port=[YOUR SMTP SERVER PORT]
spring.mail.username=[YOUR USERNAME]
spring.mail.password=[YOUR PASSWORD]

# Other properties
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000

# TLS , port 587
spring.mail.properties.mail.smtp.starttls.enable=true

# SSL, post 465
#spring.mail.properties.mail.smtp.socketFactory.port = 465
#spring.mail.properties.mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory
```

For uploading files, you need to specify your upload directory in `application.properties` as follows:
```
app.upload.dir=.
```
