pipeline {
    agent { label 'local' }  // Đặt đúng label của Node bạn đã tạo (ví dụ: 'local')


    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/jetbrainer0211/AutoTestPrj.git'
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Allure Report Generation') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
}
