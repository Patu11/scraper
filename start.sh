#!/bin/sh

echo Starting backend and gateway services
java -jar backend.jar &
java -jar gateway.jar