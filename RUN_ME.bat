@echo off
title Supelion's Music Player
set /p NAME="Input the name of the .mp3 / .wav file you would like to play: "
echo Running main.py
python main.py %NAME%
pause