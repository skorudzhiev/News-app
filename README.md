# News app
**Version 1.0 2017/06/06**

The app shows popular news on a variety of topics from [The Guardian API](http://open-platform.theguardian.com/access/) 
organized on a clean UI, providing the ability on item selection to open the article in a web browser. 

![alt text](https://github.com/skorudzhiev/News-app/blob/master/NewsApp%20-%20Nexus_5X_API_24_5554.png)

### Device permissions
* Request user's permission to access the internet
```XML
<uses-permission android:name="android.permission.INTERNET"/>
```
* Request user's permission to access device network state
```XML
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## General Usage Notes

```Gradle
defaultConfig {
  minSdkVersion 15
  targetSdkVersion 25
}
```
The main functionality of the app is to show popular news on a variety of topics provided from [The Guardian API](http://open-platform.theguardian.com/access/)

* The app has a single activity populated in a List Layout with the most recent news stories
* Upon item selection from the list of news, user is prompted to open the story in a browser of his personal choice 

## Features

The app has a very basic code implementation which includes a manual network connection to the API, 
fetching and parsing JSON data converted and presented in ListActivity. 
The app does not include the use of external libraries.

* [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object) used as the project Model
```Java
public News(String Title, String Section, String Date, String Url){
        title = Title;
        section = Section;
        date = Date;
        url = Url;
    }
```
* [ArrayAdapter](https://developer.android.com/reference/android/widget/ArrayAdapter.html) used to populate the ListLayout
```Java
public class NewsAdapter extends ArrayAdapter<News> {
...
```
* [Loader](https://developer.android.com/guide/components/loaders.html) implementation to increase the overall performance by placing the network operations on a second thread
```Java
public class NewsLoader extends AsyncTaskLoader<List<News>> {
...
```
* QueryUtils class which provides the helping methods for the background app functionality not visible to the user such as
  * createURL 
  * makeHttpRequest
  * readFromStream
  * extractFeatureFromJson
  * fetchNewsData
  
* NewsActivity class used to merge the overall code functionality necessary to create the displayed content
