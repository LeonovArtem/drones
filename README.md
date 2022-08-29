## Drones

---

## Description

- Uses H2 in-memory database
- cron job (check drones battery levels) run one minute and create log to ``` /var/log/check_drone_battery.log ```

## How to run App

1) Run App to local: ```./mvnw spring-boot:run ``` or start Docker: ``` docker-compose up -d ```.
   App is starting on port: 9001
