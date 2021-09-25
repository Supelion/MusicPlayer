@echo off

cd src

javac Main.java
java Main

echo.
echo ------------- END OF OPERATION -------------
echo.

del Main.class
echo Deleted Main.class
echo.

pause