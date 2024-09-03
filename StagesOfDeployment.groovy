pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Tool to be used: Maven'
                echo 'build the code using a build automation tool, package code.'
            }
        }
        stage('Unit And Integration Checks') {
            steps {
                echo 'Tool to be used: Katalon Studio'
                echo 'run unit tests to ensure the code functions as expected and run integration tests to ensure the different components of the application work together as expected'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Tool to be used: Crucible'
                echo 'integrate a code analysis tool to analyse the code and ensure it meets industry standards'
            }
        }
        stage('Security Scan') { // enter EMAIL here
            steps {
                echo 'Tool to be used: SonarQube'
                echo 'perform a security scan on the code using a tool to identify any vulnerabilities'
            } 
            
            post {
                success {
                    mail to: "dawtlianmang1@gmail.com",
                    subject: "Build Status Email",
                    body: "Security Scan was successful"
                }
            }
        }
        stage('Deploy To Staging') {
            steps {
                echo 'Tool to be used: AWS EC2 Instance'
                echo 'deploy the application to a staging server'
            }
        }
        stage('Integration Tests On Staging') { // enter EMAIL here
            steps {
                echo 'Tool to be used: Github'
                echo 'run integration tests on the staging environment to ensure the application functions as expected in a production-like environment.'
            }
            post {
                success {
                    mail to: "dawtlianmang1@gmail.com",
                    subject: "Build Status Email",
                    body: "Integration Tests were successful"
                }
            }
        }
        stage('Deploy To Production') {
            steps {
                echo 'Tool to be used: AWS EC2 Instance'
                echo 'Deploy to Production Server (AWS Ec2 instance)'
            }
        }
    }
}
