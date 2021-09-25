import os

try:
    from pydub import AudioSegment
except:
    os.system("pip3 install pydub")

source = input("Input the name of the .mp3 / .wav file you would like to play: ")

if (source.endswith(".mp3")):
    source += ".mp3"
    destination = "./src/Music/audio.wav"

    print("Converting from .mp3 to .wav...")

    sound = AudioSegment.from_mp3(source)
    sound.export(destination, format = "wav")

os.system("compile.bat")