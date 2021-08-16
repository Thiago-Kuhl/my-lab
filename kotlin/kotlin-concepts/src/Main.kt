/**
 * This is a documentation-style comment.
 * You can reference things here, like the [introduction] function.
 * You can also reference parameters, like the [arguments].
 * @param arguments
 * @author Thiago Kühl
 */

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

fun nullables() {
    val myName = "Thiago"
    val nickname: String? = null
    val lastname: String? = "Kühl"

    println(nickname)

    val nicknameLength = nickname?.length?.toDouble()
    println(nicknameLength)

    if (lastname != null) {
        println("My lastname is ${lastname.length} characters long!")
    } else {
        println("I don't have a last name!")
    }

    if (nickname?.isEmpty() == true) {
        println("You don't have a nickname. It's length is ${nickname.length}")
    }

//    val notNullNickname = requireNotNull(nickname)
//    println(notNullNickname.length)

    val myNickname = nickname ?: myName //elvis operator
    println(myNickname)

    val lastBirthdayYear = 2020
    val myAge: Int? = 20

    val myAgeNotNull = myAge ?: return

    val yearOfBirth = lastBirthdayYear - myAgeNotNull

    println("I was born in $yearOfBirth")
}

fun nullablesChallenge() {
    /*
    *Challenge:
    * Declare a variable of type String? called 'password' and assign a value to it.
    * Using an if expression, check the level of password strength, and assign an appropriate message to another
    * constant named 'message'. Then print out the message.
    *
    * Levels are designed as follows:
    *
    * 0 characters or 'null' --> "Ehm, you need a password to keep safe!"
    * 1-5 characters --> "Weak password! Try adding a few more symbols to it!"
    * 6-10 characters --> "Medium-strength password."
    * 11-15 characters --> "No one is getting through this!"
    * 15+ characters --> "Ironclad!"
    */

    val password: String? = "asdfgh1234567899"

    val message: String = if (password.isNullOrEmpty()) {
        "Ehm, you need a password to keep safe!"
    } else if (password.length in 1..5) {
        "Weak password! Try adding a few more symbols to it!"
    } else if (password.length in 6..10) {
        "Medium-strength password."
    } else if (password.length in 11..14) {
        "No one is getting through this!"
    } else {
        "Ironclad!"
    }

    println(message)

}

fun dataTypesAndOperationsChallenge() {
    /*
    * Challenge:
    * Create several values describing you as a person, in pieces of data. The pieces of data are follows:
    * - Name
    * - Last Name
    * - Nickname (if exists)
    * - Country
    * - Age
    *
    * Then find your year of birth using your age, and print out your data in the following format.
    *
    * Note: If yo're underaged (< 18 years old), omit your 'name', and if you don't have a nickname, remove it from
    * the format.
    *
    * Format:
    * "$name '$nickname' $lastname, born on $yearOfBirth, in $country", if you have a nickname, otherwise, remove th
    * nickname from the format.
    */

    val myName = "Thiago,"
    val myLastName = "Kühl"
    val myNickname: String? = "tkuhl,"
    val myCountry = "Brazil"
    val myAge = 18
    val myLastBirthdayYear = 2020
    val myYearOfBirth = myLastBirthdayYear - myAge

    /*
    * My solution:
    val message = if (myNickname.isNullOrEmpty()) {
        if (myAge < 18) {
            "$myLastName, born on $myYearOfBirth, in $myCountry"
        } else {
            "$myName $myLastName, born on $myYearOfBirth, in $myCountry"
        }
    } else {
        if (myAge < 18) {
            "'$myNickname' $myLastName, born on $myYearOfBirth, in $myCountry"
        } else {
            "$myName '$myNickname' $myLastName, born on $myYearOfBirth, in $myCountry"
        }

    }
    println(message)
    */

    //Video solution
    val nameToPrint = if (myAge >= 18) myName else ""
    val nicknameToPrint = myNickname ?: ""

    val userData = "$nameToPrint $nicknameToPrint $myLastName, born on $myYearOfBirth, in $myCountry"

    println(userData)

}

fun dataPairsAndTriples() {
    val fullName = Pair<String, String>("Thiago", "Kühl")
    val birthday = Triple(3, 9, 2000)

    val (name, lastname) = fullName
    println("My fullname is $name, $lastname")

    val person = Pair("Thiago Kuhl", birthday)

    val nameUsingOrdering = person.first
    val birthdayUsingOrdering = person.second

    val (Myname, bday) = person
    val (day, mounth, _) = bday

    val yearOfBirth = bday.third
    print("$Myname was born on $day/$mounth, year unknown!")

}

fun dataPairsAndTriplesChallenge(){
    /*
    * Create a Pair which holds about a Bank Account.
    * A Bank Account needs to have a Credit Card connected to it, and a balance. (Hint: You can nest a Triple in a Pair)
    * A Credit Card should have a Card number, security code, and the type of the card (e.g. "Visa", "Mastercard").
    *
    * Print out the data for the Account, while hiding the security code.
    */
    val creditCard = Triple("12345 34565 12345 9734", "123", "Visa")
    val bankAccount = Pair(10000.0, creditCard)

    val (balance, creditCardInfo) = bankAccount
    val (cardNumber, _, cardType) = creditCardInfo

    println("Balance: R$$balance - Card Number: $cardNumber - Card Type: $cardType")
}

fun main(arguments: Array<String>) {
//    introduction()
//    booleans()
//    logicOperators()
//    ifStatement()
//    ifStatementChallenge()
//    nullables()
//    nullablesChallenge()
//    dataTypesAndOperationsChallenge()
//    dataPairsAndTriples()
    dataPairsAndTriplesChallenge()
}