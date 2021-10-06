import speech_recognition as sr

r = sr.Recognizer()

text = ''
triggerWord = '맵피'
trigger = False

while (True):
    with sr.Microphone() as source:
        print("Say Something : ")
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio, language='ko-KR')
            print("You Said : {}".format(text))
        except:
            print("Sorry could not recognize")
        
    if triggerWord in text:
        trigger = True
        print("triggered")
        break

print("End loop")