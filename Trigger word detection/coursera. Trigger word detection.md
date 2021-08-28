# coursera. Sequence Models. Trigger word detection

## Trigger Word Detection
In this article, they learned about applying deep learning to speech recognition before. So in this assignment, we will construct a speech dataset and implement an algorithm for tigger word detection. Trigger word detection is the technology that allows devices to wake up upon hearing a certain word.

For this exercise, out trigger word will be "Activate." Every time it hears you say "activate," it will make a "chiming" sound. By the end of this assignment, you will be able to record a clip of yourself talking, and have the algorithm trigger a chime when it detects you saying "activate."

In this assignment you will learn to:
- Structure a speech recognition project.
- Synthesize and process audio recordings to create train/dev datasets
- Train a trigger word detection model and make predictions


## 1. Data synthesis: Sreating a speech dataset
we'd like to detect the word "activate" in working environments. We will create recordings with a mix of positive words and negative words on different background sounds.

### 1.1. Listening to the data
there are positive, negative and background sounds in raw_data directory. We will use these 3 type of recordings to create a labelled dataset.

### 1.2.From audio recordings to spectrograms
What really is an audio recording? A microphone records little variations in air pressure over time. We can think of an audio recording is a long list of numbers measuring the little air pressure changes detected by the microphone. We will use audio sampled at 44100Hz. This means the microphone gives us 44100 numbers per second. Thus, a 10 second audio clip is represented by 44100 * 10 numbers.

It is quite difficult to figure out from this "raw" representation of audio whther the word "activate" was said. So we will compute a spetrogram of the audio. (The spectrogram tells us how much different frequencies are present in an audio clip at a moment in time.)

The dimension of the ouput spectrogram depends upon the hyperparameters of the spectrogram software and the length of the input. In this, we will be working with 10 sencond audio clips as the "standard length" for our training exaples. The number of timesteps of the spectrogram will be 5511. 

```
Time steps in audio recording before spectrogram
(441000, )
Time steps in input after spectrogram 
(101, 5511)
```

Now, we can define:
```
Tx = 5511 # Te number of time steps input to the model from the spectrogram
n_freq = 101 # Number of frequencies input to the model at each time step of the spectrogram
```

10 seconds is our default training example length. 10 seconds of time can be discretized to different numbers of value. We've seen 441000(raw audio) and 5511(spectrogram). In former case, each step represents 10/441000 = 0.000023 seconds. In the second case, each step represents 10/5511 = 0.0018 seconds.

For the 10 seconds of audio, the key values we will see in this assignment are:
- 441000 (raw audio)
- 5511 = Tx(spectrogram output, and dimension of input to the neural network)
- 10000(used by the pydub module to synthesize audio)
- 1375 = Ty(the number of steps in the output of the GRU we'll uild)

### 1.3. Generating a single training example
- 음성 파일의 녹음된 형식은 어떤가?
	- 배경소리 10초 위에 정답(activate)과 오답을 놓아서 훈련 샘플을 만든다. (정답: 0-4개, 오답: 0-2개)
	- pydub 패키지를 통해 오디오를 다룰 것이다. pydub의 데이터 구조는 최소 단위 1ms이고, 10초라면 10000ms이다.

### 함수들
1. ```get_random_time_segment(segment_ms)``` gets a random time segment in our background audio.
2. ```is_overlapping(segment_time, existing_segments)``` checks if a time segment overlaps with existing segments
3. ```insert_audio_clip(background, audio_clip, existing_times)``` inserts an audio segment at a random time in our background audio using ```get_random_time_segment``` and ```is_overlapping```
4. ```insert_ones(y, segment_end_ms)``` inserts 1's into our label vector y after the word "activate"

#### 함수 get_random_time_segment(segment_ms)
random time segment를 반환한다.




# Reference
- [github. deep-learning-coursera. Trigger word detection v1](https://github.com/Kulbear/deep-learning-coursera/blob/master/Sequence%20Models/Trigger%20word%20detection%20-%20v1.ipynb)
- [07-3. 순환 신경망 LSTM, GRU - (3). tistory](https://excelsior-cjh.tistory.com/185)
