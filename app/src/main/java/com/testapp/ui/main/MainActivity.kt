package com.testapp.ui.main

import androidx.lifecycle.ViewModelProvider
import com.testapp.R
import com.testapp.ui.base.BaseActivity
import com.testapp.utils.ViewModelProviderFactory
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.testapp.BR
import com.testapp.databinding.ActivityWithFrameBinding

class MainActivity : BaseActivity<ActivityWithFrameBinding, MainViewModel>(),
    HasAndroidInjector {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_with_frame

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory).get(MainViewModel::class.java)
}