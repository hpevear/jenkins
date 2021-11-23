node{
  stage('GIT Checkout') {
            git branch: 'master',
                credentialsId: 'Jenkins_Github',
                url: 'git@github.com:hpevear/jenkins.git'
  }
	
  stage('Maven Build'){
		sh 'mvn clean package'
  }
}
