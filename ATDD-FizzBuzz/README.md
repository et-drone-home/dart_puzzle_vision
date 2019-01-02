# FizzBuzz with ATDD

Your job is to use acceptance test driven development to create a FizzBuzz web API.
The FizzBuzz API will receive the number used in its algorithm from a remote number service. That service is not available right now, so you'll need to provide a stand-in double that responds in a similar way.

## Number service
The number service responds to a GET request to "/number" with the following JSON response:
```
{ number: 3 }
```
The actual number returned will be a random integer between 1 and 100.

## FizzBuzz API
Another team is expecting to make a GET request to "/fizzbuzz" and receive for example:
```
{ response: "fizz" }
```

