#!/usr/bin/env bash
sbt -DrunLocal=true -Dperftest.runSmokeTest=false Gatling/test