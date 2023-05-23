data class Question(val text: String, val options: List<String>)

class Survey {
    private val questions = mutableListOf<Question>()

    fun addQuestion(question: Question) {
        questions.add(question)
    }

    fun displayQuestions() {
        for ((index, question) in questions.withIndex()) {
            println("${index + 1}. ${question.text}")
            for ((optionIndex, option) in question.options.withIndex()) {
                println("   ${optionIndex + 1}. $option")
            }
            println()
        }
    }

    fun takeSurvey(): List<Int> {
        val responses = mutableListOf<Int>()
        for (question in questions) {
            println(question.text)
            for ((optionIndex, option) in question.options.withIndex()) {
                println("${optionIndex + 1}. $option")
            }
            var response: Int
            do {
                print("Enter your response (1-${question.options.size}): ")
                response = readLine()?.toIntOrNull() ?: 0
            } while (response !in 1..question.options.size)
            responses.add(response)
        }
        return responses
    }
}

fun main() {
    val survey = Survey()

    val question1 = Question("What is your favorite color?", listOf("Red", "Blue", "Green"))
    val question2 = Question("What is your favorite food?", listOf("Pizza", "Burger", "Pasta"))
    val question3 = Question("What is your favorite animal?", listOf("Dog", "Cat", "Elephant"))

    survey.addQuestion(question1)
    survey.addQuestion(question2)
    survey.addQuestion(question3)

    survey.displayQuestions()

    val responses = survey.takeSurvey()

    println("\nSurvey Responses:")
    for ((index, response) in responses.withIndex()) {
        val question = survey[index]
        println("${question.text}: ${question.options[response - 1]}")
    }
}
