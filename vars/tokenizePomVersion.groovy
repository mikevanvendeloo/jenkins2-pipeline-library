#!/usr/bin/groovy
List call() {
    def matcher = readFile('pom.xml') =~ '<version>(.+?-.*)</version>'
    return matcher ? matcher[0][1].tokenize(".") : []
}

