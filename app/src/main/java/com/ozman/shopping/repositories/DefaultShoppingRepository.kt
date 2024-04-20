package com.ozman.shopping.repositories

import androidx.lifecycle.LiveData
import com.ozman.shopping.data.local.ShoppingDao
import com.ozman.shopping.data.local.ShoppingItem
import com.ozman.shopping.data.remote.PixabayAPI
import com.ozman.shopping.data.remote.responses.ImageResponse
import com.ozman.shopping.util.Resource
import java.lang.Exception

class DefaultShoppingRepository(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An error occures", null)

            } else {
                Resource.error("An error occures", null)
            }
        } catch (e: Exception) {
            Resource.error("couldn't reach server. check your internet connection", null)
        }
    }
}