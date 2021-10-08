import sys
import time
import speech_recognition as sr

r = sr.Recognizer()

def launch():
    text = ''
    trigger = False
    triggerWord = "맵피"

    with sr.Microphone() as source:
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio, language='ko-KR')
        except:
            print(-1)
    if triggerWord in text:
        trigger = True
        print(1)

def main(argv):
    launch()

if __name__ == "__main__":
    main(sys.argv)
