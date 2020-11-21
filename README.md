# Spring Boot, Java 11, Firebase on Heroku Prototype

Sandbox example project working with Java &amp; Firebase on Heroku

## Setup & Requirements

- [java 11](https://openjdk.java.net/projects/jdk/11/) > `brew install openjdk@11`
- [maven](https://maven.apache.org/) > `brew install maven`
- [Heroku & Heroku cli](https://devcenter.heroku.com/articles/heroku-cli) > `brew tap heroku/brew && brew install heroku`
- [Firebase Project](https://firebase.google.com/docs/projects/learn-more)
  - [associated firestore](https://firebase.google.com/docs/firestore)
    - new collection > todos
      - Todo > priority / description / created_date / due_date
  - [firebase & service account secrets](https://stackoverflow.com/questions/37418372/firebase-where-is-my-account-secret-in-the-new-console)
    - local development save in .env file / on heroku save as config variable
      - SERVICE_JSON > this is your google credentials JSON
      - DB_URL > your firestore url

### How to Run

1. clone repo
2. ensure requirements are met
3. login to Heroku cli & use `heroku create` inside repository folder
4. To run locally
   - ensure .env is filled out
   - `mvn clean compile package`
   - `heroku local` > live @ localhost:5000
5. To run on heroku
   - ensure config variables filled out
   - `git push heroku main`
   - `heroku open` > open in browser



## Working with Java & Firebase

