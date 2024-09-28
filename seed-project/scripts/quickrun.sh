#!/bin/bash

original_dir=$(pwd)

SCRIPT_DIR=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)
cd $SCRIPT_DIR
classes=$(cat .dependency.classes)

cd $SCRIPT_DIR/..
java -cp target/classes:$classes me.babaki.seed.App "$@"

cd "$original_dir"
