#!/bin/bash


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=fr.uga.miage.m1:projet_int_G4 \
  -Dsonar.host.url=http://im2ag-sonar.u-ga.fr:9000 \
  -Dsonar.login=7c91a795edc14b4e5427747724898b132e5bb8e4