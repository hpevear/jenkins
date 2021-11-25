node{
  stage('GIT Checkout') {
	  git branch: '${branch}',
        credentialsId: 'Jenkins_Github',
        url: 'git@github.com:hpevear/jenkins.git'
  }
	
  stage('Maven Build'){
    def mvnHome = tool name: 'Maven-3.8.4', type: 'maven'
    sh "${mvnHome}/bin/mvn package -DskipTests"
  }
	
  stage('Copy Jar Stop_Start Service'){
	  sh 'sudo /home/ec2-user/scripts/myjenkins.sh ${JOB_NAME} ${service}'
  }
}
