<div align="center">
<img
  src="https://i.imgur.com/oUoXCAW.png"
  title="Android Sample VIDY SDK"
  width="400px">
</div>

## Summary

The Vidy SDK is an Android library that injects Vidy's into an Android Application. 

## Prerequisites
* Android SDK v21

#### Permissions
The Vidy SDK requires the Internet permission. Add the following line to your `AndroidManifest.xml` file.
```
<uses-permission android:name="android.permission.INTERNET" />
```
#### Gradle
Include the following repositories in your `build.gradle` file.
```
repositories {
    maven { url "https://dl.bintray.com/vidycoin/maven" }
    maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
}
```
Include the Vidy SDK.
```
implementation 'com.vidy.sdk:vidysdk:0.1.3'
```

## Steps to use

### 1. Initialize App Id
Set the Application ID in a custom `Application`, `Activity`, or `Fragment`. This only needs to be called one time.
```
VidySdk.setApplicationId("APPLICATION_ID");
```

### 2. Embed Vidy's search
The Vidy SDK can be integrated into an `Activity`, `Fragment`, `ViewGroup`, or `TextView`. 
#### Activity
```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);
    VidySdk.init(this, "POST_ID");
}
```

#### Fragment
```
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_layout, container, false);
    VidySdk.init(this, view, "POST_ID");
    return view;
}
```

#### ViewGroup
```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);
    ViewGroup viewGroup = (ViewGroup)activity.findViewById(android.R.id.content);
    VidySdk.init(this, viewGroup, "POST_ID");
}
```

#### TextView
```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);
    TextView textView = findViewById(R.id.textView);
    VidySdk.init(this, textView, "POST_ID");
}
```
### 3. Manually update UI
The SDK requires inflation and changes that occur on the UI thread. This can be manually controlled by adding two parameters to the function. Set `shouldUpdate` to false and provide a `VidyCallback` to notify when the UI is ready to load.
```
VidySdk.init(Activity activity, String postId, boolean shouldUpdate, VidyCallback vidyCallback)
```
```
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fullscreen);

	VidySdk.setApplicationId(this, "bd6e3c14-57ad-4d26-b7f2-b92a4c750c19");
	vidySdk = VidySdk.init(this, "samplepost", false, new VidyCallback() {
		@Override
		public void onSuccess(VidyState vidyState) {
			if(vidyState == VidyState.INITIALIZED) {
				vidySdk.postUpdate();
			}

		}

		@Override
		public void onFailure(VidyError vidyError) {

		}
	});
}
```
## Output

| Before | After | On Press | 
:-------------------------:|:-------------------------:|:-------------------------:
![](doc/before.png)|![](doc/after.png)|![](doc/vidy.png)


| On Completion | Social | Login |
:-------------------------:|:-------------------------:|:-------------------------:
![](doc/embed.png)|![](doc/social.png)|![](doc/login.png)

