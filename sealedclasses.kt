sealed class Result // implicitly abstract, can have abstract members therefore

class Success : Result()
class Failure(val errorMessage: String) : Result() // different properties

enum class ResultEnum(val errorMessage: String?) {
    SUCCESS(null), // unnecessary
    FAILURE("Not Found") // can be ardcoded as enums can have only one instance
}

fun main() {
    val result: Result = Failure("Not Found")
    when (result) {
        is Success -> println("Congrats!")
        is Failure -> println("Sorry you failed because: ${result.errorMessage}")
    }

    val enumResult = ResultEnum.FAILURE
    when(enumResult) {
        ResultEnum.SUCCESS -> println("Congrats!")
        ResultEnum.FAILURE  -> println("Sorry you failed because: ${enumResult.errorMessage}")
        else -> { // this is required }
    }
}
