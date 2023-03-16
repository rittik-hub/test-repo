import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.*
import java.net.URL
    

            withSonarQubeEnv(installationName: 'sonar_jenkins', credentialsId: 'sonartest') {
                sh "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectName=rittik -Dsonar.projectKey=rittik"
           }
           
 
