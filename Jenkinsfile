
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
                    sh 'mkdir test-report'
                    junit 'test-report/*.xml'
                }
            }
        }
    }
}