package com.dev.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPluginWithId implements Plugin<Project> {
    @Override
    void apply(Project target) {
        classPluginTask(target);
    }

    void classPluginTask(Project target) {
        def map = [description: "buildSrcPluginWithIdTask task", group: "customPlugins", type: DefaultTask]
        target.task(map, "buildSrcPluginWithIdTask") {
            // When you'll not specify the type - it's ok. yor currently created task will be extended from DefaultTask.class by default
            // However you can extend your task from any of org.gradle.api.Task subclasses
            println "conf phase. Task classPluginTask" // Will be triggered on config phase only
            println "description: \"${description}\", group: \"${group}\", actions: \"${actions}\"" // Will be triggered on config phase only
            doLast { // this is the org.gradle.api.Action will be appended to the end of the "actions" List in order to determination
                println "execution phase, Action 1" // Will be triggered on exec phase only
            }
            doFirst { // this is the org.gradle.api.Action will be appended to the beginning of the "actions" List in order to determination
                println "execution phase, Action 2" // Will be triggered on exec phase only
            }
            doLast { // this is the org.gradle.api.Action will be appended to the end of the "actions" List in order to determination
                println "execution phase, Action 3" // Will be triggered on exec phase only
            }
            doFirst { // this is the org.gradle.api.Action will be appended to the beginning of the "actions" List in order to determination
                println "execution phase, Action 4" // Will be triggered on exec phase only
            }
            println "description: \"${description}\", group: \"${group}\", actions: \"${actions}\"" // Will be triggered on config phase only
            println "path task: ${path}" // Will be triggered on config phase only
            //gradle.taskGraph.allTasks
        }
    }
}