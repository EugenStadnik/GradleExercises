This is the common *gradle* usage explanation file. And the project is created to achieve *gradle* learning purposes.

The *gradle* is a project build tool like *maven*, *ant* or *make* or even any other build .bat and .sh script.

The main advantages of the *gradle* are:
- DSL (Domain Specific Language) syntax based on Groovy or Kotlin PL instead of bulky XML. Such ensures more laconic build script comparing to XML.
- convention over configuration (common project structure for all projects)
- dependency management support
- easy extendable and flexible tasks
- download dependencies and builds them in parallel comparing to *maven* (faster build process)

The is also a disadvantage of *gradle*:
- high entry threshold due to *gradle* scripts based on Groovy or Kotlin PL. (Developer should to learn additional PL)

To be able to run *gradle*:
---
- install *java* and *gradle* first using any available source (Debian repository or binaries download).
- ensure "java" and *gradle* commands available from any point of OS

To generate *gradle* bare-bone project:
---
- create project directory (let's say /home/user/IdeaProjects/MyProject)
- enter project directory using CMD
- type "$ gradle init" in the project directory and follow instructions

There are 6 key interfaces in the common implementation of *gradle*:
---
- *org.gradle.api.invocation.Gradle* represents an invocation of Gradle (kind of entry point)
- *org.gradle.api.invocation.Settings* is a binary representation of ///MyProject/settings.gradle file (multiple settings can be created at a MyProject)
- *org.gradle.api.Project* is a binary representation of ///MyProject/build.gradle file (multiple build files can be created at a MyProject)
- *org.gradle.api.Task* is a binary representation of each *task* described in a ///MyProject/build.gradle file (example: ***test** { useJUnitPlatform() }* where ***test*** is a *task*)
- *org.gradle.api.Action* is a binary representation of each *action* described in a *task* (example: *test { **useJUnitPlatform()** }* where ***useJUnitPlatform()*** is an *action*)
- *org.gradle.api.Script* is a binary representation of a groovy script (any described *.gradle file)