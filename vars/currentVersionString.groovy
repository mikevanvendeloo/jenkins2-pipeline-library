#!/usr/bin/groovy
String call() {
    def matcher = readFile('pom.xml') =~ '<version>(.+?-.*)</version>'
    //matcher ? matcher[0][1].tokenize(".") : null
    return matcher ? matcher[0][1] : null
}