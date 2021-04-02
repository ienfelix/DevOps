
pipeline {
    agent any

    stages {
        
        stage('Build') { 

            agent {
                docker {
                    label 'maven'
                    image 'maven:3.6.3-openjdk-11'
                }
            }

            steps {
                sh 'mvn -B -DskipTests clean package' 
            }

        }
    }
}