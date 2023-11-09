pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Your SCM checkout step here
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Your build steps here (if any)
            }
        }

        stage('Test') {
            steps {
                // Run Selenium tests
                script {
                    def seleniumHome = tool 'Selenium'
                    def browser = 'chrome' // or 'firefox'

                    sh "${seleniumHome}/java -jar ${seleniumHome}/selenium-server-standalone.jar -role hub -port 4444"
                    sh "${seleniumHome}/java -Dwebdriver.chrome.driver=${seleniumHome}/chromedriver -jar ${seleniumHome}/selenium-server-standalone.jar -role node -hub http://localhost:4444/grid/register -browser browserName=${browser},maxInstances=5"

                    sh "./gradlew test" // or your test command
                }
            }
        }

        stage('Deploy') {
            steps {
                // Your deployment steps here (if any)
            }
        }
    }

    post {
        always {
            // Clean up resources, e.g., stop Selenium server
            script {
                sh "pkill -f selenium-server-standalone"
            }
        }
    }
}
