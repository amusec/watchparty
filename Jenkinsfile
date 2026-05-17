pipeline {

    agent any
    
    stages{
        
        stage('Make mvnw executable'){
            steps{
                sh 'chmod +x mvnw'
            }
        }
        
        stage('Build the Spring Boot app'){
        
            steps{
                sh './mvnw clean package'
            }
        }
        
        stage('run the app now'){
            steps{
                sh './mvnw spring-boot:run'
            }
        }
        
    
    }

}