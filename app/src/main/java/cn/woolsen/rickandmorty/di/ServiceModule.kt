package cn.woolsen.rickandmorty.di

import cn.woolsen.rickandmorty.network.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideCharacterService(
        retrofit: Retrofit
    ): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

}