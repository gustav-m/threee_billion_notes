# threee_biliion_notes - Generative Music written in Java

  * A small piece of program that plays totally differnt tune each time, based on the randomness of Java's Math.random() function and sets of tonal unit that I considered would sound beautiful in randomness.
  * This program only uses java's built-in sound library and some formula to generate sounds and has no dependency against any external libralies or external sound files.

## Prerequisites
openjdk 1.8.0_171 or later.

## Installing and Running

```
git clone https://github.com/gustav-m/threee_billion_notes.git
cd threee_biliion_notes
javac *.java
java ThreeBillion
```

## How it works
  * The program has sets of frequencies which I chose arbitrary from equal temperament system.
    * As of now the sets are based on Dorian Scale(natural minor scale with raised 6th); and each set is more or less characterized by its fourth intervals.
  * Four independent threads plays notes chosen randomly from the set of notes described above.
    * Each note's duration and envelope are decided also randomly in run time.
  * The tonal center of the song changes in run time randomly.

## Author
Hisashi "Gustav" Mizuno

**open for hire**

## Lisence
GPL-3.0
