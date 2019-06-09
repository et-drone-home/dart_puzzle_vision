# Rock Paper Scissors with ATDD

This is an example of using acceptance test driven development to create an online Rock Paper Scissors game.
The game will receive the opponent's gesture from a remote service. That service is not available right now, so you'll need to provide a stand-in double that responds in a similar way.

## Gesture service
The gesture service responds to a GET request to "/gesture" with a JSON response like:
```
{ "gesture": "rock" }
```
The actual gesture returned will be random.

## Rock Paper Scissors

Be sure to install the Chrome Driver for Selenium
```
brew tap homebrew/cask && brew cask install chromedriver
```

Run cucumber tests using `gradle cucumber` from the command line or in the Gradle menu of IntelliJ.

