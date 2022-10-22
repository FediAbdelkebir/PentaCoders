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
}

