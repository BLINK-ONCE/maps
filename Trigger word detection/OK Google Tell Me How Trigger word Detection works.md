# OK Google post. how trigger word detection works?


Is google always listening to what I say? the answer is NO.


**We have to know a lot about sequence modilling and how it is done using RNN(Recurrent Neural Networks) and LSTM(Long Short Term Memory). and we might have also build an RNN.**

Trigger word detection is still evolving so ther isn't a consensus yet on the best trigger word detection algorithm.

On this article, we will try to understand on implemetation of such a system using Kears.

## Overview
We will be using pre-recorded audio files for the purposes of illustration but you can record your own audio using microphone of your computer. The way we generate training examples are as follows. We have 3 types of audio recordings.

- Background
- Positive words
- Negative words

Background is other noises. Positive words are correct trigger words. Negative words are incorrect.

To generate lot of training examples we take the audio files with background noise and overlay positive and negative words on them at random time intervals. 


## Setting Up
in this sector, we're gonna write codes written by python with Anaconda, Jupyter notebooks etc.

We do the pre-processing.

## Building the Model

Most of our pre-processing steps are now done. We just need to build the model train it and perform predictions.



# Reference
- [OK Google Tell Me How trigger word Detection works](https://medium.com/x8-the-ai-community/ok-google-tell-me-how-trigger-word-detection-works-f6f877e2cd8b)