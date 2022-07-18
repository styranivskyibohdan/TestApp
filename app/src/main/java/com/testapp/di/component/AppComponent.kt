package com.testapp.di.component

import android.app.Application
import android.content.Context
import com.testapp.TestAppApplication
import com.testapp.di.modules.ActivityBuilder
import com.testapp.di.modules.GeneralModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules =
    [AndroidInjectionModule::class,
        GeneralModule::class,
        ActivityBuilder::class]
)
interface AppComponent {

    fun inject(app: TestAppApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}