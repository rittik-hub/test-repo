#!/usr/bin/env groovy

def call(String buildType, LinkedHashMap buildConfig){
    String sonarqubeServer = "https://localhost:9000"
    
   
   

    
    switch(buildType) 
    {
        
        
        case "Maven":
            mavenParams = "${buildConfig.mavenProfile} ${buildConfig.mavenExtraParams}"
            withSonarQubeEnv(installationName: 'sonar_jenkins', credentialsId: 'sonartest') 
             {
                sh "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectName=${buildConfig.sonarqubeProjectKey} -Dsonar.projectKey=${buildConfig.sonarqubeProjectKey} ${mavenParams}"
             }
           
    }
}
