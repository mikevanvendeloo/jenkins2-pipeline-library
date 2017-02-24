#!/usr/bin/env groovy
def isMaster = env.BRANCH_NAME == 'master'
def isDevelop = env.BRANCH_NAME == 'develop'
properties([
        buildDiscarder(logRotator(numToKeepStr: '30'))
])
def getCurrentVersion() {
    def matcher = readFile('pom.xml') =~ '<version>(.+?-.*)</version>'
    //matcher ? matcher[0][1].tokenize(".") : null
    return matcher ? matcher[0][1] : null
}

def getCommitId() {
    return sh(script: 'git rev-parse --short HEAD', returnStdout: true)?.trim()
}