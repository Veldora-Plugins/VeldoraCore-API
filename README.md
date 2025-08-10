**Maven**
```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.Veldora-Plugins</groupId>
	    <artifactId>VeldoraCore-API</artifactId>
	    <version>1.0</version>
	</dependency>

```

**Gradle**
```kotlin
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}

	dependencies {
	        implementation("com.github.Veldora-Plugins:VeldoraCore-API:1.0")
	}
```

```groovy
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	dependencies {
	        implementation 'com.github.Veldora-Plugins:VeldoraCore-API:1.0'
	}
```
