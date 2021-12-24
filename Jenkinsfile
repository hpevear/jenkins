node{
  stage('GIT Checkout') {
	  git branch: 'master',
        credentialsId: 'Jenkins_Github',
        url: 'git@github.com:hpevear/jenkins.git'
  }
	
  stage('Maven Build'){
    def mvnHome = tool name: 'Maven-3.8.4', type: 'maven'
    sh "${mvnHome}/bin/mvn package -DskipTests"
  }
	
  stage('Copy Jar to S3'){
	  dir(){
            pwd(); //Log current directory
            withAWS(region:'us-east-1',credentials:'aws-key') {
                def identity=awsIdentity();//Log AWS credentials
                // Upload files from working directory 'dist' in your project workspace
                 s3Upload(file:'target/jenkins-0.0.1-SNAPSHOT.jar', bucket:'myjenkins-artifacts-deploy', path:'')
            }
        };
  }
	
}
