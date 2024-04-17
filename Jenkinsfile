pipeline {
    agent any
    stages {
        stage('Build Dia') {
            steps {
                build job: 'organice-dia', wait: true
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }      
        stage('Build Image') {
            steps {
                script {
                    dia = docker.build("alfredjynx/dia:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dia.push("${env.BUILD_ID}")
                        dia.push("latest")
                    }
                }
            }
        }
    }
}