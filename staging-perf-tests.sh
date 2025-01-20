#!/usr/bin/env bash
sbt -DrunLocal=true -Dperftest.runSmokeTest=true Gatling/test