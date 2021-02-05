package daniellopes.io.newsappstarter.model


import com.google.gson.annotations.SerializedName
import daniellopes.io.newsappstarter.model.Article

data class NewsResponse(
    @SerializedName("articles")
    val articles: MutableList<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)