#!/usr/bin/env groovy

def call(String buildType){
    String sonarqubeServer = "https://localhost:9000"
    
   
   

    
    switch(buildType) 
    {
        
        
        case "Maven":
            withSonarQubeEnv(installationName: 'sonar_jenkins', credentialsId: 'sonartest') {
                sh "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectName=rittik -Dsonar.projectKey=rittik"
           }
           
    }
}
