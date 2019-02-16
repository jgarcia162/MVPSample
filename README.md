Here is a simple app used to demonstrate an implementation of the MVP design pattern. 

The app connects to [SWAPI](https://swapi.co/) to display a list of Star Wars characters. A random character can be chosen from the list and displayed via AlertDialog. 
This implementation is strictly for minimal demonstration purposes and does not include any data persistence, Network error fall-backs or orientation change caching. 

Networking done with [Retrofit](https://square.github.io/retrofit/)

Image loading done with [Picasso](http://square.github.io/picasso/)

`master` and `solution` branches include a bare-bones implementation

`optimized` branch includes:
 * Feature to allow sorting and shuffling of the list
 * optimization on `PersonAdapter.java` that implements [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil)
 * `PersonSorter.kt` helper class