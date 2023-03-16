
    

            withSonarQubeEnv(installationName: 'sonar_jenkins', credentialsId: 'sonartest') {
                sh "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectName=rittik -Dsonar.projectKey=rittik"
           }
           
 
