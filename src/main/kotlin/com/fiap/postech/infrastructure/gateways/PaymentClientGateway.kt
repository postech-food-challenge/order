package com.fiap.postech.infrastructure.gateways

import com.fiap.postech.application.gateways.PaymentGateway
import com.fiap.postech.infrastructure.client.payment.CreatePaymentRequest
import com.fiap.postech.infrastructure.client.payment.CreatePaymentResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class PaymentClientGateway(val client: HttpClient, val paymentServiceURL: String): PaymentGateway {
    override suspend fun createPayment(request: CreatePaymentRequest): CreatePaymentResponse {
        return client.patch("$paymentServiceURL/v1/orders/${request.orderId}") {
            setBody(request)
        }.body()
    }
}