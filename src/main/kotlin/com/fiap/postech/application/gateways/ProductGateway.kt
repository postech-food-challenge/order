package com.fiap.postech.application.gateways

import com.fiap.postech.infrastructure.client.product.ProductResponse

interface ProductGateway {
    fun getProduct(id: Long): ProductResponse
}