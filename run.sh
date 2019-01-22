#!/usr/bin/env bash
javac -cp lanterna.jar:. SpaceSanta.java
resize -s 170 52
java -cp lanterna.jar:. SpaceSanta
