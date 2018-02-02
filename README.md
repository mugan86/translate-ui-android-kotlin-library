# Translate (i18n) Module in Kotlin to use in Android

Library create by Anartz Mugika (mugan86@gmail.com)

### Instructions to download library from Maven ###

[ ![Download](https://api.bintray.com/packages/amugika/maven/i18n/images/download.svg) ](https://bintray.com/amugika/maven/i18n/_latestVersion)

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
* Adapt to Devices with SDK 25 or more recent.
* Add more languages to use in Dialog selection.
* Optimize code with one objective: Easy use.

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

* Change to select language:
```
    LocaleHelper.changeLang(this, lang)
```
* Restart App (make this action after change lang automatically)
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
 
 ### MIT License

Copyright (c) 2018 Anartz Mugika Ledo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

