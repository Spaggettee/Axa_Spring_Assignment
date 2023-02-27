#!/bin/bash
TARGETDIR=src/main/java/jp/co/axa/apidemo/models

mkdir tempOutput

java -jar openapi-generator-cli-6.3.0.jar generate \
  -i ./Specification.yaml \
  -g spring \
  -o ./tempOutput \
  -p modelPackage=$BASEPACKAGE.models

mv tempOutput/src/main/java/models ../$TARGETDIR

rm -r tempOutput