@echo off

cd src

echo Compiling main.java
javac Main.java
echo Running main.java
java Main

echo.
echo ------------- END OF OPERATION -------------
echo.

del Main.class
echo Deleted Main.class
echo.

pause