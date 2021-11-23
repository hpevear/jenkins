node{
 stage('GIT Checkout') {
        steps {
            git branch: 'master',
                credentialsId: 'Jenkins_Github',
                url: 'git@github.com:hpevear/jenkins.git'

            sh "ls -lat"
        }
    }
	
	stage('Maven Build'){
		sh 'mvn clean package'
	}
}
