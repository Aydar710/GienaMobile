package com.gina.gienamobile.presentation.main

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
import com.gina.gienamobile.databinding.ActivityMainBinding
import com.gina.gienamobile.presentation.tutorial.TutorialFragment
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeableMethod
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main), CardStackListener {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by viewBinding()
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CardStackAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setupCardStackView()

        viewModel.requestEvent()

        observeViewModel()

        Handler().postDelayed({
            binding.vatabeView.setSpeech("Какое красивое имя! А чем ты занимаешься?", 15)
            showVatabe()
        }, 100)
    }

    private fun observeViewModel() {
        with(viewModel) {
            currentQuestion.observe(this@MainActivity) {
                setQuestionText(it.question.text)
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

    private fun setQuestionText(text: String) {
//        binding.tvQuestion.text = text
    }

    private fun showVatabe() {
        ObjectAnimator.ofFloat(binding.vatabeView, "translationY", (binding.vatabeView.height * -1).toFloat())
            .apply {
                duration = 600
                start()
            }
    }

    private fun hideVatabe() {
        ObjectAnimator.ofFloat(binding.vatabeView, "translationY", (binding.vatabeView.height).toFloat()).apply {
            duration = 600
            start()
        }
    }

    private fun openTutorialFragment(tutorialText: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, TutorialFragment.newInstance(tutorialText))
            .commit()
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
