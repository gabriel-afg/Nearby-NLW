package com.gabriel.nearby.ui.screen.market_details

import com.gabriel.nearby.data.model.Rule

data class MarketDetailsUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null,
)