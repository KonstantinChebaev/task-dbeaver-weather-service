# WeatherService
WeatherService is a solution for task: https://github.com/dbeaver/info/wiki/Task-Weather-service

##  🚀 Getting Started
This section provides a high-level quick start guide
### Local Development

### Prerequisites
- [Java](https://www.oracle.com/java/technologies/) 11
- [Gradle](https://gradle.org) 7.1.1
- [PostgreSQL](https://www.postgresql.org/) 11 or higher
- [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)

**Step 1. Set up environment variables**

Database
- ```DB_USER```  = postgres user
- ```DB_PASS```  = postgres password

**Step 2. Configure DB**

You can configure DB on your local machine, or you can use Docker to run DB-instance

*Configure local on your local machine*

Create DB ```weatherServiceDB``` on 5432 port

**Step 3. Build app**

>gradlew clean build

**Step 4. Run**

_Idea_:
- create SpringBoot configuration
- set up environment variables to configuration
- run