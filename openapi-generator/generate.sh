#!/bin/bash
SOURCEDIR=tempOutput/src/main/java/org/openapitools/model
TARGETDIR=../src/main/java/jp/co/axa/apidemo

mkdir tempOutput

rm -r $TARGETDIR/models

java -jar openapi-generator-cli-6.3.0.jar generate \
  -i ./Specification.yaml \
  -g spring \
  -o ./tempOutput \

mv $SOURCEDIR $TARGETDIR

mv $TARGETDIR/model $TARGETDIR/models

rm -r tempOutput