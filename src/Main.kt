import java.io.File

fun main() {
    val filePath = "file.txt"

    try {
        // Читаем содержимое файла в строку
        val content = File(filePath).readText()

        var maxLength = 0
        var currentLength = 0

        // Перебираем символы строки, начиная с первого индекса, чтобы проверять пары символов
        for (i in 0 until content.length - 1 step 2) {  // Используем диапазон с включением конечного значения
            // Берем пару символов вручную
            val firstChar = content[i]
            val secondChar = content[i + 1]

            // Проверяем, является ли пара "AB" или "CB"
            if ((firstChar == 'A' && secondChar == 'B') || (firstChar == 'C' && secondChar == 'B')) {
                currentLength++
            } else {
                maxLength = maxOf(maxLength, currentLength)
                currentLength = 0
            }
        }

        maxLength = maxOf(maxLength, currentLength)

        // Выводим результат
        println("Максимальная длина подпоследовательности: $maxLength")
    } catch (e: Exception) {
        println("Ошибка при чтении файла: ${e.message}")
    }
}

