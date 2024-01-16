package com.dev.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction;

class ReleaseTask extends DefaultTask {
    // The cache is calculated relying on inputs and outputs
    // when the inputs and outputs doesn't change so the cache is also doesn't change
    // and task rerun is not needed as the predicted task result won't change as well
    @Input
    Boolean release
    @OutputFile
    File releaseFile

    @TaskAction
    void performRelease() {
        println "buildSrc release in progress..."
    }
}
