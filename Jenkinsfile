pipeline {
    agent any
    tools {
    maven "MAVEN_HOME"
    }

    stages
            {
                stage('docker-compose UP')
                {
                    steps {
                        bat ('docker-compose -f docker-compose.yaml up -d')
                        }
                }
                stage('Executing Tests')
                 {
                    steps {
                        bat ('mvn clean test')
                        }
                    post {
                        always {
                        bat ('docker stop chrome firefox hub')
                        bat ('docker rm chrome firefox hub')
                        }
                 }
    }

    stage('reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [['target/allure-results']]
                        ])
                    }
                }
            }
        }
    }