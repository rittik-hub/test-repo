#!/usr/bin/env groovy

def call(String  pomFile, Object rtMaven, LinkedHashMap buildConfig, Object buildInfo, String projectType){
        mavenParams = "${buildConfig.mavenProfile} ${buildConfig.mavenExtraParams}"
        if (projectType == "isMonorepo") {
            if ( buildConfig.modulesToBuild[0] == 'all'){
                modulesToBuild = buildConfig.supportedModules.join(",")
            }
            else {
                modulesToBuild = buildConfig.modulesToBuild.join(",")
            }
            modulesToBuild =  "-pl ${modulesToBuild} clean install ${mavenParams}"
            rtMaven.run pom: pomFile, goals: modulesToBuild.toString(), buildInfo: buildInfo
        }
        else {
            goals =  "clean install ${mavenParams} -U"
            rtMaven.run pom: pomFile, goals: goals.toString(), buildInfo: buildInfo
        }
   
}
