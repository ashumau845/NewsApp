package info.ort.recyclerkotlin.Model

data class NewsClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)