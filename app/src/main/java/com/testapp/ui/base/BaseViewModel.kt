package com.testapp.ui.base

import androidx.lifecycle.ViewModel
import com.testapp.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel(){
    val isLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
}