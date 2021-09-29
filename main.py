import os
import sys

try:
    from pydub import AudioSegment
except:
    os.system("pip3 install pydub")

source = input("Input the name of the .mp3 / .wav file you would like to play (excluding .mp3): ")

sound = AudioSegment.from_mp3(source)
sound.export("./src/music/audio.wav", format = "wav")

print("Running compile.bat")
os.system("compile.bat")