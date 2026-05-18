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
                sh 'nohup java -jar target/watchparty-0.0.1-SNAPSHOT.jar --server.port=80 > app.log 2>&1 &'
            }
        }
        
        
        
    
    }

}