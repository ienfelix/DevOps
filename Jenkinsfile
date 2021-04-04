
pipeline {
    agent any

    tools {
        maven 'maven-3.6.3' 
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('test') {
            steps {
                sh 'mvn test`'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}