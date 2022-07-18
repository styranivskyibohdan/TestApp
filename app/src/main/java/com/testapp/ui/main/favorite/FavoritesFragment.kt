package com.testapp.ui.main.favorite

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.testapp.R
import com.testapp.ui.base.BaseFragment
import com.testapp.utils.ViewModelProviderFactory
import javax.inject.Inject
import com.testapp.BR
import com.testapp.databinding.FragmentFavoritesBinding
import com.testapp.domain.db.Article
import com.testapp.ui.base.NavigationCommand
import com.testapp.ui.main.MainActivity
import com.testapp.ui.main.article.ArticleDataItem
import com.testapp.ui.main.article.ArticleFragmentDirections

class FavoritesFragment: BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(),
    FavoritesItemViewModelListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var favoritesAdapter: FavoritesAdapter

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_favorites

    override val viewModel: FavoritesViewModel
        get() = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

    override fun onItemClick(item: Article) {
        navigate(
            NavigationCommand.To(
                ArticleFragmentDirections.toArticleDetailsFragment(
                    ArticleDataItem(
                        item.id,
                        item.imageUrl,
                        item.title,
                        item.byline,
                        item.abstractX,
                        item.publishedDate,
                        item.url,
                        item.coverImageUrl
                    )
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesAdapter = FavoritesAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        if (activity != null) {
            (activity as MainActivity).setSupportActionBar(getViewDataBinding().toolbar)
            getViewDataBinding().toolbar.title = getString(R.string.favorites)
            (activity as MainActivity).supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }

        }
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().favoritesRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().favoritesRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().favoritesRecyclerView.adapter = favoritesAdapter
    }
}