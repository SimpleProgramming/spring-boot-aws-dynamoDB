FROM openjdk:8u212-jre-alpine

ENV AWS_ACCESS_KEY=$AWS_ACCESS_KEY
ENV AWS_SECRET_KEY=$AWS_SECRET_KEY
ENV AWS_REGION = $AWS_REGION

CMD exec java -jar /app/springboot-aws-dynamodb-0.0.1-SNAPSHOT.jar
