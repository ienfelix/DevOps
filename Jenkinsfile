
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
                    sh 'ln -s tests/test-results-unit.xml $WORKSPACE'
                    junit "test-results-unit.xml"
                }
            }
        }
    }
}