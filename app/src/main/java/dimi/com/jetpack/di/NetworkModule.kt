package dimi.com.jetpack.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dimi.com.jetpack.network.JetpackApi
import dimi.com.jetpack.util.BASE_URL
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): JetpackApi {
        return retrofit.create(JetpackApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
//    @Provides
//    @Reusable
//    @JvmStatic
//    internal fun provideRetrofitInterface(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .build()
//    }
}