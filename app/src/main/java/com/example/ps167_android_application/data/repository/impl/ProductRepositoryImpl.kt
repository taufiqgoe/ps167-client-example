package com.example.ps167_android_application.data.repository.impl

import android.annotation.SuppressLint
import com.example.ps167_android_application.api.ProductApiService
import com.example.ps167_android_application.data.model.GeneralResponse
import com.example.ps167_android_application.data.model.ProductDto
import com.example.ps167_android_application.data.repository.ProductRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductApiService
) : ProductRepository {

    @SuppressLint("CheckResult")
    override fun getProduct(id: String): Flowable<GeneralResponse<ProductDto>> {
        val data = PublishSubject.create<GeneralResponse<ProductDto>>()
        service
            .getProduct(id)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe(
                {
                    data.onNext(it)
                },
                {
                    data.onNext(GeneralResponse(it.message,null))
                }
            )

        return data.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    override fun getProductByName(
        name: String,
        page: Int,
        size: Int
    ): Flowable<GeneralResponse<List<ProductDto>>> {
        val data = PublishSubject.create<GeneralResponse<List<ProductDto>>>()
        service
            .listByName(name, page, size)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe(
                {
                    data.onNext(it)
                },
                {
                    data.onNext(GeneralResponse(it.message,null))
                }
            )

        return data.toFlowable(BackpressureStrategy.BUFFER)
    }

}