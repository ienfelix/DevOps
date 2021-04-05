
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
                SCANNER_HOME = tool 'SonarQubeScanner'
                ORGANIZATION = "NinjaTi"
                PROJECT_NAME = "DevOps"
            }
            
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''$SCANNER_HOME/bin/sonar-scanner -Dsonar.organization=$ORGANIZATION \
                    -Dsonar.java.binaries=build/classes/java/ \
                    -Dsonar.projectKey=$PROJECT_NAME \
                    -Dsonar.sources=.'''
                }
                    
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}