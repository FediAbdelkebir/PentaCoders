pipeline { 
    agent any
    stages {
        stage("Cloning Project"){
            steps {
                git 'https://github.com/FediAbdelkebir/PentaCoders.git'
            }
        }
        stage("Build Project"){
            steps {
                sh 'mvn compile'
            }
        }
       // stage("Unit Test"){
         //   steps {
           //     sh 'mvn test'
          //  }
        //}
        //stage("Packaging Project"){
          //  steps {
            //    sh 'mvn package'
            //}
        //}
    }
}
