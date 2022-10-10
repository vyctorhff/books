#!/bin/bash

# As I have to create many projects, I write this file to help me on this.

echo "criando $1"
mvn archetype:generate -DgroupId=br.torugo.livro.designerpatters.caelum -DartifactId=$1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

