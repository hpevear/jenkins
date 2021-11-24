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
	
  stage('Copy Artifact'){
    fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: 'target/*.jar', renameFiles: false, sourceCaptureExpression: '', targetLocation: '/home/jenkinsapp/', targetNameExpression: '')])
  }
	
  stage('Stop_Start Service'){
    sh 'sudo systemctl stop MyJenkins'
    sh 'sudo systemctl start MyJenkins'
  }
}
