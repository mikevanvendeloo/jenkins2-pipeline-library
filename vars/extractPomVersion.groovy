#!/usr/bin/groovy

String call(String sha = 'HEAD') {
    def matcher = readFile('pom.xml') =~ '<version>(.+)-.*</version>'
    matcher ? matcher[0][1] : null
}