
pipeline {
    agent any

    tools {
        maven 'Maven' 
    }

    stages {
        stage('Compilación de Código') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Pruebas Unitarias') {
            steps {
                sh 'mvn test'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Análisis de Código') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                    
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}