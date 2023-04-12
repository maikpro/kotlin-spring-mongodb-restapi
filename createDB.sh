#!/usr/bin/env bash

docker run --name mymongodb -e  MONGO_INITDB_ROOT_USERNAME=maik -e MONGO_INITDB_ROOT_PASSWORD=maik123 -e MONGO_INITDB_DATABASE=mymongodb -p 27017:27017 -v data-vol:/data/db -d mongo:latest