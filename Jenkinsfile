pipeline {
    agent {
        docker {
            image 'hseeberger/scala-sbt:11.0.16_1.9.3_2.13.10'
        }
    }
    stages {
        stage('Check SBT version') {
            steps {
                sh 'sbt sbtVersion'
            }
        }
    }
}
