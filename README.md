# Calculator

<p align="center">
  <img src="https://github.com/VsIG-official/Calculator-OOP-Kotlin/blob/master/Calculator%20OOP.png" data-canonical-src="https://github.com/VsIG-official/Calculator-OOP-Kotlin/blob/master/Calculator%20OOP.png" width="300" height="600" />
</p>

## Table of Contents

- [Description](#description)
- [Badges](#badges)
- [Contributing](#contributing)
- [License](#license)

### Description

My small Calculator with OOP principles made in Android Studio

## Badges

> [![Language](https://img.shields.io/badge/Language-Kotlin-orange?style=flat-square)](https://en.wikipedia.org/wiki/Kotlin_(programming_language))
> [![Theme](https://img.shields.io/badge/Theme-OOP-blue?style=flat-square)](https://en.wikipedia.org/wiki/Object-oriented_programming)
> [![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)


---

## Example

```kotlin
when {
            (firstNumber.text=="0.0" || firstNumber.text=="-0.0" ||
                    firstNumber.text=="Infinity" || firstNumber.text=="-Infinity")
                    && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2.toDouble()
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() && !oneNumberOperation ->
            {
                result = OperatorClass.checkTwoNumbers(tempValue1.toDouble(), tempValue2.toDouble())
            }

            !firstNumber.text.isNullOrEmpty() && oneNumberOperation ->{
                result = OperatorClass.checkOneNumber(tempValue1.toDouble())
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }
        }
```

---

## Contributing

> To get started...

### Step 1

- 🍴 Fork this repo!

### Step 2

- **HACK AWAY!** 🔨🔨🔨

---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2021 © <a href="https://github.com/VsIG-official" target="_blank">VsIG</a>.
