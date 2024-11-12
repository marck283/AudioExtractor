#!/bin/bash

if [ $# -lt 2 ]; then
  echo "Numero di argomenti non sufficiente.">&2;
  echo "Utilizzo: ./start.sh <path file input> <path file output>.">&2;
fi

./build/libs/audio-extractor-shadow-1.0.jar "$1" "$2"
