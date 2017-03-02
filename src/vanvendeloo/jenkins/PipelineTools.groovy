package vanvendeloo.jenkins

def getCurrentVersion() {
    def matcher = readFile('pom.xml') =~ '<version>(.+?-.*)</version>'
    //matcher ? matcher[0][1].tokenize(".") : null
    return matcher ? matcher[0][1] : null
}

def getCommitId() {
    echo "Retrieving commit Id..."
    return sh(script: 'git rev-parse --short HEAD', returnStdout: true)?.trim()
}