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
	  dir(''){
            pwd(); //Log current directory
	    sh ''' cd target '''
	    sh ''' tar cvf ../jenkins.tar *.jar '''
	    sh ''' cd .. '''
            withAWS(region:'us-east-1',credentials:'aws-key') {
                def identity=awsIdentity();//Log AWS credentials
                // Upload files from working directory 'dist' in your project workspace
                 s3Upload(file:'jenkins.tar', bucket:'myjenkins-artifacts-deploy', path:'')
            }
        };
  }
	
}
