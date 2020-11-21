import gtts
from playsound import playsound

def alexa():
    tts = gtts.gTTS("Hello, my name is Alexa! I am your new virtual assistant! I cannot due much yet as I am very basic.")
    tts.save("hello.mp3")
    playsound("hello.mp3")



def siri():
    tts = gtts.gTTS("Hello, my name is Siri! I am your new virtual assistant! I cannot do much yet as I am very basic.")
    tts.save("hello.mp3")
    playsound("hello.mp3")


def main():

    assistant = input("Would you like to speak to Alexa or Siri: ")
    if assistant == "alexa":
        alexa();
    elif assistant == "siri":
        siri();
    else:
        print("We currently do not have that virtual assistant. Please choose between alexa or siri!")

if __name__ == "__main__":
    main()