package com.example.harrypotter.data.repository

import com.example.harrypotter.data.remote.api.HarryPotterApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeHarryPotterApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var harryPotterApi: HarryPotterApi

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        harryPotterApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterApi::class.java)
    }

    @Test
    fun testGetAllCharacters() = runBlocking{
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = harryPotterApi.getAllCharacters()
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

}