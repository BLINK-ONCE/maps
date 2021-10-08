import sys
import time
import speech_recognition as sr

r = sr.Recognizer()

def launch():
    time.sleep(3)
    text = ''
    trigger = False
    triggerWord = "맵피"

    with ar.Microphone() as source:
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio, language='ko-KR')
        except:
            print(-1)
    if triggerWord in text:
        trigger = True
        print(1)
        break

def main(argv):
    launch()

if __name__ == "__main__":
    main(sys.argv)
