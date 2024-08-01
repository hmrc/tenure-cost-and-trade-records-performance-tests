#!/usr/bin/env bash
sbt -DrunLocal=false -Dperftest.runSmokeTest=false Gatling/test