package com.example.testapp.di

import android.content.Context
import androidx.room.Room
import com.example.testapp.Constans.APP_DATABASE
import com.example.testapp.Constans.BASE_URL
import com.example.testapp.data.api.Api
import com.example.testapp.data.repository.CharacterRepositoryImp
import com.example.testapp.data.room.AppDatabase
import com.example.testapp.domain.repository.CharacterRepository
import com.example.testapp.domain.use_cases.GetAllCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun providesApi(okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            APP_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(database: AppDatabase, api: Api): CharacterRepository {
        return CharacterRepositoryImp(database = database, api = api)
    }

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(repository: CharacterRepository): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(repository = repository)
    }
}