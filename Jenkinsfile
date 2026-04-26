pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat '"C:\\OrangeC\\Classes\\DevOps\\apache-maven-3.9.12\\bin\\mvn.cmd" clean package'
            }
        }

        stage('Test') {
            steps {
                bat  '"C:\\OrangeC\\Classes\\DevOps\\apache-maven-3.9.12\\bin\\mvn.cmd" test'
            }
        }

        stage('Docker Build') {
    steps {
        bat 'docker build -t orangec88/fibonacci-app .'
    }
}

stage('Docker Login') {
    steps {
        bat 'echo Portal@XR1988 | docker login -u xroc88 --password-stdin'
    }
}

stage('Docker Push') {
    steps {
        bat 'docker push orangec88/fibonacci-app'
    }
}
        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f deployment.yaml'
                bat 'kubectl apply -f service.yaml'
            }
        }
    }
}