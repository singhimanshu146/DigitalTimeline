# DigitalTimeline

DigitalTimeline is a Java-based project that organizes activities into a chronological timeline.

## Current Features

- Create activities with a title and description.
- Automatically record the date and time of each activity.
- Create task activities using Java inheritance.
- Mark tasks as completed.
- Store multiple activities using `ArrayList`.
- Sort activities chronologically.
- Display activities with formatted timestamps.
- Count the total number of activities.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Git and GitHub

## Project Structure

```text
DigitalTimeline/
├── README.md
├── .gitignore
└── src/
    ├── Main.java
    ├── model/
    │   ├── Activity.java
    │   └── TaskActivity.java
    └── service/
        └── Timeline.java
```

## How to Run

Compile the source files from the project root:

```bash
javac -d out src/Main.java src/model/Activity.java src/model/TaskActivity.java src/service/Timeline.java
```

Run the application:

```bash
java -cp out Main
```

## Planned Features

- Search and filter activities.
- Accept activity details through user input.
- Save and load activities from a file.
- Integrate a database and Spring Boot backend.
- Build a React frontend.
- Explore AI-powered search and insights.