package com.ozman.shopping.repositories

import androidx.lifecycle.LiveData
import com.ozman.shopping.data.local.ShoppingItem
import com.ozman.shopping.data.remote.responses.ImageResponse
import com.ozman.shopping.util.Resource

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>
    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}