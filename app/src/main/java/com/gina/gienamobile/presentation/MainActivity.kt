package com.gina.gienamobile.presentation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gina.gienamobile.R
import com.gina.gienamobile.R.layout
import com.gina.gienamobile.databinding.ActivityMainBinding
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeableMethod
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), CardStackListener {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by viewBinding()
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CardStackAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        supportActionBar?.hide()

        setupCardStackView()

        viewModel.requestEvent()
        viewModel.requestEvent()

        observeViewModel()
    }

    private fun observeViewModel() {
        with(viewModel) {
            currentCard.observe(this@MainActivity) {
                adapter.addEvent(it)
                setUserBalance(it.user.moneyQty)
            }
        }
    }

    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
//        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        binding.cardStackView.layoutManager = manager
        binding.cardStackView.adapter = adapter
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    //Achtung refactor and throw it away!!!!!
    private fun setUserBalance(balance: Int) {
        try {
            val currentBalance =
                binding.tvMoney.text.toString().takeIf { !it.isNullOrBlank() }?.split(" ")?.get(0)?.toInt()
            binding.tvMoney.text = "$balance ₽"
            currentBalance?.let {
                if (balance > currentBalance) {
                    binding.tvMoney.setTextColor(resources.getColor(R.color.green))
                    Handler().postDelayed({
                        binding.tvMoney.setTextColor(resources.getColor(R.color.white))
                    }, 500)
                } else {
                    binding.tvMoney.setTextColor(resources.getColor(R.color.red))
                    Handler().postDelayed({
                        binding.tvMoney.setTextColor(resources.getColor(R.color.white))
                    }, 500)
                }
            }
        } catch (e: Exception) {
            Log.e("", "", e)
        }
    }

    private fun showVatabe() {
        ObjectAnimator.ofFloat(binding.ivVatabe, "translationY", (binding.ivVatabe.height * -1).toFloat()).apply {
            duration = 500
            start()
        }
    }

    private fun hideVatabe() {
        ObjectAnimator.ofFloat(binding.ivVatabe, "translationY", (binding.ivVatabe.height).toFloat()).apply {
            duration = 500
            start()
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        viewModel.requestEvent()
    }

    override fun onCardRewound() {}

    override fun onCardCanceled() {}

    override fun onCardAppeared(view: View?, position: Int) {}

    override fun onCardDisappeared(view: View?, position: Int) {}
}
