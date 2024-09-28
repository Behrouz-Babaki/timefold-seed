#!/bin/bash

original_dir=$(pwd)

SCRIPT_DIR=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)
cd $SCRIPT_DIR/..

mvn -q dependency:build-classpath -Dmdep.outputFile=$SCRIPT_DIR/.dependency.classes

cd "$original_dir"
