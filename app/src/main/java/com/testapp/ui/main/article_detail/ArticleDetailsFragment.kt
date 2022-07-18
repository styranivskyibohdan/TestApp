package com.testapp.ui.main.article_detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.testapp.R
import com.testapp.databinding.FragmentArticleDetailsBinding
import com.testapp.ui.base.BaseFragment
import com.testapp.ui.main.MainActivity
import com.testapp.ui.main.article.ArticleDataItem
import com.testapp.utils.AppConstants
import com.testapp.utils.ViewModelProviderFactory
import javax.inject.Inject
import com.testapp.BR

class ArticleDetailsFragment:
    BaseFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>() {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var articleDataItem: ArticleDataItem? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article_details

    override val viewModel: ArticleDetailsViewModel
        get() = ViewModelProvider(this, factory).get(ArticleDetailsViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            articleDataItem = arguments?.getParcelable(AppConstants.ARTICLE)
            if (articleDataItem != null) { // To check if article is favorite or not
                articleDataItem?.id?.let { viewModel.getFavoriteById(it) }
            }
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpToolbar()
        setArticle()
    }

    private fun setArticle() {
        if (articleDataItem != null) {
            getViewDataBinding().article = articleDataItem
        }
    }

    private fun setUpToolbar() {
        if (activity != null) {
            (activity as MainActivity).setSupportActionBar(getViewDataBinding().toolbar)
            val actionBar = (activity as MainActivity).supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            actionBar?.setDisplayShowTitleEnabled(false)
        }
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
    }
}