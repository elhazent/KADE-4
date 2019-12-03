package com.elhazent.education.kade4.ui.activity.detailmatch

import com.elhazent.education.kade4.network.InitRetrofit
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMatchPresenterTest{

    @Mock
    lateinit var view: DetailMatchContract.View

    @Mock
    private lateinit var api: InitRetrofit

    @Mock
    private lateinit var match: ResponseMatch

    private lateinit var presenter: DetailMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailMatchPresenter(view, api)
    }

    @Test
    fun getDataEventTest() {
        val id = "576606"
        presenter.getDetailLeagueId(id)
        argumentCaptor<RepositoryCallback<ResponseMatch>>().apply {
            verify(api).getDataEvent(eq(id), capture())
            firstValue.onDataLoaded(match)
        }
        verify(view).showLoading()
        verify(view).showTeam(match.events)
    }

    @Test
    fun getDataEventErrorTest() {
        val id = "2"
        presenter.getDataEvent(id)
        argumentCaptor<RepositoryCallback<ResponseMatch>>().apply {
            verify(api).getDataEvent(eq(id), capture())
            firstValue.onDataError("Error get data")
        }
        verify(view).hideLoadingError("Error get data")
    }
}