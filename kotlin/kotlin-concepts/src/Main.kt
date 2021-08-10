/**
 * This is a documentation-style comment.
 * You can reference things here, like the [introduction] function.
 * You can also reference parameters, like the [arguments].
 * @param arguments
 * @author Thiago Kühl
 * */

fun introduction() {
    var myAge: Int = 20
    val myName: String = "Thiago"
    val myLastName = "Kühl"
    val myWeight: Double = 86.0

    println("My name is ${"$myName $myLastName"} i'm $myAge years old.")

    myAge += 1

    println("My name is ${"$myName $myLastName"} i'm $myAge years old and weighs ${myWeight}kg.")

    val fullname = "$myName $myLastName"
    println(fullname)

    val ageAsString = myAge.toString()
    println(ageAsString)

    val ageFromString = "21".toInt()
    println(ageFromString)

    val nameLength = fullname.length
    print(nameLength)

    // This is a simple line comment.

    /*
    * This is a multiline comment.
    * You don't need to add // before each line.
    * */
}

fun booleans() {
    val isProgrammingAwesome = true

    println("Is programming awesome? $isProgrammingAwesome")

    val myAge = 20

    val isLegalDrivingAge = myAge >= 18

    println(isLegalDrivingAge)

    val timAge = 21

    val isTimOlder = timAge > myAge

    println(isTimOlder)

    val yearOfBirthday = 1999

    val isBornInTwentiethCentury = yearOfBirthday < 2000

    println(isBornInTwentiethCentury)

    val strangerName = "Tim"
    val myName = "Thiago"

    val isSameName = strangerName == myName

    println(isSameName)

    val areNamesDifferent = myName != strangerName
    println(areNamesDifferent)

    println(!areNamesDifferent)

    val firstObject = Any()
    val secondObject = Any()

    println(firstObject === secondObject)
    println(firstObject !== secondObject)

    val isNameEmpty = myName.isEmpty()
    println(isNameEmpty)

    /*
    * Challenge 1:
    * Check and store in a Boolean if password is secure.
    * For simplicify, we can say that a password is secure if it has
    * at least 10 characters.
    */
    val password = "1234567890"
    val isPasswordSecure = password.length >= 10

    println("Password is secure? $isPasswordSecure")

    /*
    * Challenge 2:
    * Check if two people have the same name length.
    */
    val firstName = "Thiago"
    val secondName = "Leticia"
    val nameLengthIsEqual = firstName.length == secondName.length

    println("Name length is equal? $nameLengthIsEqual")
}

fun logicOperators() {
    val myAge = 20
    val country = "Croatia"

    val isLegalDrivingAge = (myAge >= 18 && country == "Croatia") or (myAge >= 16 && country == "USA")
    println(isLegalDrivingAge)

    if (isLegalDrivingAge) {
        println("You can drive!")
    } else {
        println("You've got a bit more time to go!")
    }

    if (myAge >= 18) println("I'm an adult!") else println("I'm still underaged!")

    val ageMessage = if (myAge >= 18) "I'm an adult!" else "I'm still underaged!"
    println(ageMessage)

    println(if (myAge >= 18) "I'm an adult!" else "I'm still underaged!")
}

fun ifStatement() {
    val myAge = 20

    if (myAge >= 18) {
        val country = "Croatia"

        if (country == "USA") {
            print("You're allowed to drive, but not drink!")
        } else if (country == "Croatia") {
            println("You're allowed to both drink and drive (not at the same time)!")
        }
    }

//    country.length - out of scope
    val yearOfBirth = 2000

    val generationCohort = if (yearOfBirth > 1964 && yearOfBirth < 1980) {
        "Generation X"
    } else if (yearOfBirth > 1979 && yearOfBirth < 1995) {
        "Millenial"
    } else {
        "Generation Z"
    }

    println(generationCohort)
}

fun ifStatementChallenge() {
    /*
    * Challenge:
    * Check if the user data for registring an account is valid. Data is valid if:
    * 1. Property is not empty;
    * 2. Username has at least 6 characters;
    * 3. Password has at least 10 characters;
    * 4. The email contains '@' and a '.'.
    */

    val username = "ThiagoK"
    val password = "1234567890"
    val email = "thiago@gmail.com"

    val someFieldIsEmpty = username.isEmpty() || password.isEmpty() || email.isEmpty()
    val isUsernameValid = username.length >= 6
    val isPasswordValid = password.length >= 10
    val isEmailValid = email.contains("@") && email.contains(".")

    val message = if (someFieldIsEmpty) {
        "You must fill in your data!"
    } else if (!isUsernameValid) {
        "Username needs to be at least 6 charancters long!"
    } else if (!isPasswordValid) {
        "Passord needs to be at least 10 charancters long!"
    } else if (!isEmailValid) {
        "Invalid email format!"
    } else {
        "Sucessful registration"
    }

    println(message)
}

fun main(arguments: Array<String>) {
//    introduction()
//    booleans()
//    logicOperators()
//    ifStatement()
    ifStatementChallenge()
}