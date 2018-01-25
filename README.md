# Translate (i18n) Module in Kotlin to use in Android

[![](https://jitpack.io/v/mugan86/translate-ui-android-kotlin-library.svg)](https://jitpack.io/#mugan86/translate-ui-android-kotlin-library/1.3-stable)

Library create by Anartz Mugika (mugan86@gmail.com)

### Instructions to download library from Maven ###

Reference :https://jitpack.io/#mugan86/translate-ui-android-kotlin-library/1.4

In select project **build.gradle** file:
```
	allprojects {
		repositories {
			jcenter()
		}
	}
```
In select module **build.gradle** file with gradle >= 3.0 use **'implementation'** and gradle < 3.0 use **'compile'**:
```
	dependencies {
    	        implementation 'amldev.i18n:library:1.4'
    	}

```
### Next version features ###
* Add more languages to use in Dialog selection.

### New version features ###
* Update Gradle :white_check_mark:
* Adapt with new SDKs (remove depprecated) :white_check_mark:
* Distribute with Maven :white_check_mark:

### Instructions in English
Library to create apps in different languages. For now it is only prepared for English, Spanish and Basque.
The instructions for Android Studio are very simple, we clone the repository and after that, we do in our Android project that we want to import the module.
* File / New / Import Module
* Select the module **"i18n"**

We recompilate the project and we already have prepared to make use of this bookshop.
To make the correct use in the library, we have to add the following in the activity:
```
//To use LocaleHelper select language
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }
```
And to do the different operations of the library:

* Guardar un nuevo idioma:
```
    LocaleHelper.changeLang(this, lang)
```
* Reiniciar la app (normalmente va junto con el cambio de idioma)
```
    LocaleHelper.restartApp(this)
```
### Instrucciones en Español.

Librería para crear apps en diferentes lenguajes. Por ahora solo está preparada para inglés, español y euskera. 
Las instrucciones para Android Studio son muy simples, clonamos el repositorio y después de ello, hacemos en nuestro proyecto de Android que queremos importar el módulo.
* File / New / Import Module
* Seleccionamos el módulo **"i18n"**

Recompilamos el proyecto y ya tenemos preparado para hacer uso de esta librería.
Para hacer el uso correcto en la librería, tenemos que añadir lo siguiente en la actividad:
```
//To use LocaleHelper select language
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }
```
Y para hacer las diferentes operaciones de la librería:
* Guardar un nuevo idioma:
```
    LocaleHelper.changeLang(this, lang)
```
* Reiniciar la app (normalmente va junto con el cambio de idioma)
```
    LocaleHelper.restartApp(this)
```
 
