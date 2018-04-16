# EventListener
EventListener is small library and is used for communication between classes like broadcaste signals

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
	        compile 'com.github.prabhat1707:EventListener:1.0'
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
- if default is

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

###### This library is very simple and smaller the other just try it !

Thank You..



 
