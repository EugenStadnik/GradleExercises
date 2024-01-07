This is the common *gradle* usage explanation file. And the project is created to achieve *gradle* learning purposes.

The *gradle* is a project build tool like *maven*, *ant* or *make* or even any other build .bat and .sh script.

The main advantages of the *gradle* are:
- DSL (Domain Specific Language) syntax based on Groovy or Kotlin PL instead of bulky XML. Such ensures more laconic build script comparing to XML.
- convention over configuration (common project structure for all projects)
- dependency management support
- easy extendable and flexible tasks (doesn't support by Maven)
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
- *org.gradle.api.invocation.Gradle* represents an invocation of Gradle (kind of entry point). Contains *TaskExecutionGraph* object.
- *org.gradle.api.initialization.Settings* is a binary representation of ///MyProject/settings.gradle file (multiple settings can be created at a MyProject)
- *org.gradle.api.Project* is a binary representation of ///MyProject/build.gradle file (multiple build files can be created at a MyProject). Contains *java.util.Set* of *org.gradle.api.Task* objects dependent on *Project* and stored in *Map*.
- *org.gradle.api.Task* is a binary representation of each *task* described in a ///MyProject/build.gradle file (example: ***test** { useJUnitPlatform() }* where ***test*** is a *task*). Contains *java.util.List* of *org.gradle.api.Action* objects.
- *org.gradle.api.Action* is a binary representation of each *action* described in a *task* (example: *test { **useJUnitPlatform()** }* where ***useJUnitPlatform()*** is an *action*)
- *org.gradle.api.Script* is a binary representation of a groovy script (any described *.gradle file)

So can make a conclusion the *gradle* is just a regular *java* application.

The *gradle* lifecycle consists of:
---
1. All /usr/share/gradle/init.d/init*.gradle scriptS execution in lexicographical order. During the phase all related *org.gradle.api.Script* objects are initialized and executed. At the finish stage of current phase the *org.gradle.api.invocation.Gradle* object is initialized. The init*.gradle file presence is not mandatory. The blank *org.gradle.api.invocation.Gradle* object will be initialized in worst case.
2. ///MyProject/settings.gradle scripT execution. During the phase all related *org.gradle.api.Script* objects are initialized and executed. At the finish stage of current phase the *org.gradle.api.initialization.Settings* object is initialized. IS NOT NEEDED FOR SINGLE MODULE PROJECT. The blank *org.gradle.api.initialization.Settings* object will be initialized in worst case.
3. ///MyProject/build.gradle scriptS execution. During the phase all related *org.gradle.api.Script* objects are initialized and executed. At the finish stage of current phase the *org.gradle.api.Project* objectS are initialized.
4. Built *org.gradle.api.Task* execution. At the phase the *org.gradle.api.Project* object aggregates all related *org.gradle.api.Task* and only during this phase all determined *org.gradle.api.Action* objects will be executed

The ***1*** and ***2*** are init phases. The ***3*** is a config phase. The ***4*** is an exec phase.

*1. *org.gradle.api.invocation.Gradle* object*
---
- place ///MyProject/usr/share/gradle/init.d/* files to /usr/share/gradle/init.d/ folder
- Observe and investigate files
- Run *$ gradle* for current project and analyze results

*2. *org.gradle.api.initialization.Settings* object*
---
- Observe and investigate ///MyProject/settings.gradle file
- Run *$ gradle* for current project and analyze results

*3. *org.gradle.api.Project* object*
---
- Observe and investigate ///MyProject/build.gradle *println* code snippets
- Run *$ gradle* for current project and analyze results

*4. *org.gradle.api.Task* object*
---
- The *org.gradle.api.Task* interface implementation contains multiple initializers for variate use cases.
- The common *org.gradle.api.Task* interface implementation initializer is *public Task task(String name) {}* such can be invoked as *task("hello")* in a *build.gradle* script
- Observe and investigate ///MyProject/build.gradle "hello" task implementations
- Run *$ gradle* for current project and analyze results
- Run *$ gradle hello* for current project, analyze results and compare difference with the previous invocation results
- Run *$ gradle hello7* for current project, analyze results and compare difference with the previous invocation results

**org.gradle.api.Action* object*
---
Just register and implement some actions in a task like:

*doFirst { println "To do smthng" }*

OR

*doLast { println "To do smthng else" }*

To show all tasks available:
---
Type ***$ gradle tasks*** in CMD of root project folder.

Also let's imagine the ***gradle.taskGraph.whenReady*** callback is implemented and shows all tasks order and dependency chain and user triggers ***$ gradle build*** command on an empty project. The following tasks chain will be retrieved:

---- Graph:<br />
compileJava<br />
processResources<br />
classes<br />
jar<br />
assemble<br />
compileTestJava<br />
processTestResources<br />
testClasses<br />
test<br />
check<br />
build<br />

It means ***processResources*** task won't be triggered without ***compileJava*** successful execution and so on down to the TaskGraph.

The ***java*** plugin tasks dependencies:
---
https://docs.gradle.org/current/userguide/img/javaPluginTasks.png

The ***java*** plugin docs page:
---
https://docs.gradle.org/current/userguide/java_plugin.html#header