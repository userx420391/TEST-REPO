pipeline {
    agent any

    environment {
        FTP_USER = 'csc-frontend-dev\\dow_deployment'
        FTP_PASS = 'P@ssw0rd'
        FTP_SERVER = 'ftps://waws-prod-sg1-031.ftp.azurewebsites.windows.net/site/wwwroot'
        USER_LOCAL = 'dow_csc_uat'
        CYGWIN_LFTP = 'C:\\cygwin64\\bin\\lftp.exe'
    }

    stages {
        stage('Prepare Date Variables') {
            steps {
                script {
                    def now = new Date()
                    def formattedDate = now.format('yyyyMMdd')
                    env.CURRENT_DATE = formattedDate
                    env.LOCAL_DIR = "/cygdrive/c/Users/${env.USER_LOCAL}/ROOT"
                    env.REMOTE_DIR = "/site/wwwroot"
                    env.BACKUP_REMOTE_DIR = "/site/backup/ROOT_${env.CURRENT_DATE}"
                    env.TEMP_BACKUP_DIR = "C:/${env.USER_LOCAL}/temp_backup_uat"
                }
            }
        }

        stage('Backup Remote Files to Local Temp') {
            steps {
                bat "\"${env.CYGWIN_LFTP}\" -e \"set ftp:ssl-allow yes; set ftp:ssl-force yes; open -u ${env.FTP_USER},${env.FTP_PASS} ${env.FTP_SERVER}; mirror ${env.REMOTE_DIR} ${env.TEMP_BACKUP_DIR}; exit\""
            }
        }

        stage('Upload Backup to Remote Backup Directory') {
            steps {
                bat "\"${env.CYGWIN_LFTP}\" -e \"set ftp:ssl-allow yes; set ftp:ssl-force yes; set ftp:passive-mode yes; open -u ${env.FTP_USER},${env.FTP_PASS} ${env.FTP_SERVER}; mirror -R ${env.TEMP_BACKUP_DIR} ${env.BACKUP_REMOTE_DIR}; exit\""
            }
        }

        // stage('Deploy New Files to Remote Directory') {
        //     steps {
        //         bat "\"${env.CYGWIN_LFTP}\" -e \"set ftp:ssl-allow yes; set ftp:ssl-force yes; set ftp:passive-mode yes; open -u ${env.FTP_USER},${env.FTP_PASS} ${env.FTP_SERVER}; mirror -R ${env.LOCAL_DIR} ${env.REMOTE_DIR}; exit\""
        //     }
        // }
    }
}
