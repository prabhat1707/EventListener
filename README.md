# EventListener
EventListener is small library and is used for communication between classes like broadcaste signals
No Need to maintain listener reference. It auto work with app lifecycle.

# Prerequisites
- Android 14

# Installing

## Step 1:- Add it in your root build.gradle at the end of repositories:
````
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
````
## Step 2:- Add the dependency:
````

	dependencies {
	        implementation 'com.github.prabhat1707:EventListener:1.0'
	}
	
  
````

# Usage

#### SendData to Register Listener:-
````

EventListener.getInstance().post(modelClass, "From Fragment");

````

#### Rec callback of the sendData :

- if you want to rec your post modelclass as well as Tag in callback then pass ModelClass Type in DataWrapper 
````
implement Updatable<DataWrapper<ObjectClass>> :

@Override
    public void EventListenerCallback(DataWrappe<ModelClass> objectDataWrapper) {
        Toast.makeText(this, objectDataWrapper.getTag(), Toast.LENGTH_SHORT).show();
        text.setText(objectDataWrapper.getObject().getTest());
    }
    
    //  objectDataWrapper.getObject return your modelClass

````
- default is

````
implements Updatable<DataWrapper>

 @Override
    public void EventListenerCallback(DataWrapper objectDataWrapper) {
        Toast.makeText(this, objectDataWrapper.getTag(), Toast.LENGTH_SHORT).show();
      
    }
    
````
- register or unregister the callback according to your logic for ex-:

````
@Override
    protected void onResume() {
        super.onResume();
        EventListener.getInstance().registerListener(this);
    }
    
@Override
    protected void onDestroy() {
        super.onDestroy();
        EventListener.getInstance().unregisterListener(this);
    }
````

#### Contructor types:

1. EventListener.getInstance().post("From Fragment"); // only Tag

2. EventListener.getInstance().post(); // without Tag and data

3. EventListener.getInstance().post(modelClass, "From Fragment"); // with data also

#### Bugs, Feature requests

Found a bug? Something that's missing? Feedback is an important part of improving the project, so please,

<a href="https://github.com/prabhat1707/EventListener/issues/new">open an issue</a>

###### This library is very simple and smaller the other just try it !

Thank You..

# License

````
Copyright 2018 Prabhat Rai

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
````

 
