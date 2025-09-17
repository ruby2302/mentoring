pipeline {
    agent {
        docker {
            image 'hseeberger/scala-sbt:11.0.16_1.9.3_2.13.10'
        }
    }
    stages {
        stage('Lint & Static Analysis') {
            steps {
                sh 'sbt checkFmt'
            }
        }
    //    stage('Build') {
    //        steps {
    //            sh 'sbt clean compile package'
    //        }
    //    }
    //    stage('Unit Tests') {
    //        steps {
    //            sh 'sbt test'
    //        }
    //    }
    //    stage('Integration Tests') {
    //        steps {
    //            sh 'sbt it:test'
    //        }
    //    }
    //    stage('Build Docker Image') {
    //        steps {
    //            sh 'docker build -t my-app:${GIT_COMMIT} .'
    //        }
    //    }
    //    stage('Push Artifacts') {
    //        steps {
    //            sh 'sbt publish'
    //            sh 'docker push my-app:${GIT_COMMIT}'
    //        }
    //    }
    }
    post {
        always {
            junit '**/target/test-reports/*.xml'
        }
    }
}