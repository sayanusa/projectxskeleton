package com.nusa.projectxskeleton.di

import androidx.room.Room
import com.nusa.projectxskeleton.BuildConfig
import com.nusa.projectxskeleton.data.AppExecutor
import com.nusa.projectxskeleton.data.repository.CommentRepository
import com.nusa.projectxskeleton.data.source.local.LocalDataSource
import com.nusa.projectxskeleton.data.source.local.room.CommentDatabase
import com.nusa.projectxskeleton.data.source.remote.RemoteDataSource
import com.nusa.projectxskeleton.data.source.remote.network.ApiService
import com.nusa.projectxskeleton.domain.repository.ICommentRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutor() }
    single<ICommentRepository> {
        CommentRepository(
            get(),
            get()
        )
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val databaseModule = module {
    factory { get<CommentDatabase>().commentDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            CommentDatabase::class.java,"comment.db"
        ).fallbackToDestructiveMigration().build()
    }
}