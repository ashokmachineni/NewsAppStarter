package daniellopes.io.newsappstarter.presenter.news

import daniellopes.io.newsappstarter.model.data.NewsDataSource
import daniellopes.io.newsappstarter.presenter.ViewHome

class NewsPresenter(val view: ViewHome.View,
                    private val dataSource: NewsDataSource):NewsHome.Presenter {
}