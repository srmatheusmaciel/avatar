# Java Microservice for Generative AI Integration

This project aims to develop a microservice that receives a profile image and sends it to a Generative Artificial Intelligence (Stable Diffusion), creating creative variations of the image. The microservice will be developed in Java, using the Quarkus framework, and technologies such as Hibernate, MariaDB, JAX-RS, Reactive Programming, Mutiny, Docker, and Testcontainers.

## Technologies Used

- **Java** (JDK 21)
- **Quarkus** (Microservices framework)
- **Hibernate ORM** (For ORM with MariaDB)
- **MariaDB** (Relational Database)
- **Docker** (For containerization and development environment)
- **Testcontainers** (For tests with containers)
- **Stable Diffusion** (Generative AI for image creation)
- **AWS S3** (Storage for generated images)
- **JAX-RS** (For REST API construction)
- **Mutiny** (Reactive programming)

## Prerequisites

- Java 21
- Docker
- Maven 3.8 or higher
- AWS S3 (Configuration for image storage)
- Basic knowledge of HTTP, MariaDB, and AWS S3

## Configuration

1. **Clone the repository:**

```bash
git clone https://github.com/srmatheusmaciel/avatar.git
cd avatar
```

2. **MariaDB database configuration:**
   - Check the `application.properties` configuration for MariaDB:

```properties
quarkus.datasource.db-kind=mariadb
quarkus.datasource.jdbc.url=jdbc:mariadb://localhost:3306/customers
quarkus.datasource.username=quarkus
quarkus.datasource.password=quarkus
quarkus.datasource.devservices.init-script-path=db/migration/V1__CreateTableProfilePhotos.sql
```

3. **AWS S3 configuration:**
   - To access S3, add credentials to the `application.properties` file:

```properties
quarkus.s3.aws.credentials.type=STATIC
quarkus.s3.aws.credentials.static-provider.access-key-id=accesskey
quarkus.s3.aws.credentials.static-provider.secret-access-key=secretkey
quarkus.s3.aws.region=us-east-1
quarkus.s3.path-style-access=true
quarkus.s3.devservices.buckets=customers-profile-photos
```

4. **Stable Diffusion API configuration:**
   - Add the API URL to `application.properties`:

```properties
quarkus.rest-client.stable-diffusion-api.url=http://(IP where the API is running):7860
quarkus.rest-client.stable-diffusion-api.scope=javax.inject.Singleton
quarkus.rest-client.read-timeout=120000
```

## Running the Application

### Running in Dev Mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_** Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

### Using Docker

If you're using Docker, run the following command to create the containers:

```bash
docker-compose up --build
```

The microservice will be available at `http://localhost:8080`.

### Packaging and Running the Application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it's not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using:

```shell script
java -jar target/quarkus-app/quarkus-run.jar
```

### Building an Über-jar

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using:

```shell script
java -jar target/*-runner.jar
```

### Creating a Native Executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with:

```shell script
./target/avatar-1.0.0-SNAPSHOT-runner
```

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Testing the API

To test the API, you can use Postman or any other HTTP client.

- **Image submission endpoint:**
  - **POST** `http://localhost:8080/customers/{id}`
  - **Body:** Send the image in `multipart/form-data` format.
  - **Response:** The AI will generate creative variations of the image and return them.


## License

This project is licensed under the MIT License - see the LICENSE file for details.
