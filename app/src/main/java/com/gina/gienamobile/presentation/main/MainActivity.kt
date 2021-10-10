package com.gina.gienamobile.presentation.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gina.gienamobile.R
import com.gina.gienamobile.databinding.ActivityMainBinding
import com.gina.gienamobile.domain.model.BaseCardLocal
import com.gina.gienamobile.domain.model.EventCardLocal
import com.gina.gienamobile.domain.model.QuestionCardLocal
import com.gina.gienamobile.presentation.tutorial.TutorialFragment
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.Direction.Right
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeableMethod
import org.koin.androidx.viewmodel.ext.android.viewModel

// Never write logic in view...
class MainActivity : AppCompatActivity(R.layout.activity_main), CardStackListener {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by viewBinding()
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CardStackAdapter() }

    private var currentCard: BaseCardLocal? = null

    private var money: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setupCardStackView()

        viewModel.requestEvent()

        observeViewModel()

        setUserBalance(money)
    }

    private fun observeViewModel() {
        with(viewModel) {
            currentQuestion.observe(this@MainActivity) {
                this@MainActivity.currentCard = it
                adapter.addEvent(it)
                binding.tvNegativeAnswer.text = it.question.negativeDecisionAnswer.answerText
                binding.tvPositiveAnswer.text = it.question.positiveDecisionAnswer.answerText
                it.question.warningText?.let {
                    showVatabe()
                    binding.vatabeView.setSpeech(it, 15)
                }
                binding.tvPositiveAnswer.isVisible = true
                binding.tvNegativeAnswer.isVisible = true
            }

            currentEvent.observe(this@MainActivity) {
                this@MainActivity.currentCard = null
                adapter.addEvent(it)
                binding.tvPositiveAnswer.isVisible = false
                binding.tvNegativeAnswer.isVisible = false
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
            currentBalance?.let { currentBalanceNotNull ->
                if (balance > currentBalanceNotNull) {
                    binding.tvMoney.setTextColor(resources.getColor(R.color.green))
                    Handler().postDelayed({
                        binding.tvMoney.setTextColor(resources.getColor(R.color.white))
                    }, 500)
                } else if (balance < currentBalanceNotNull) {
                    binding.tvMoney.setTextColor(resources.getColor(R.color.red))
                    Handler().postDelayed({
                        binding.tvMoney.setTextColor(resources.getColor(R.color.white))
                    }, 500)
                } else {
                }
            }
        } catch (e: Exception) {
            Log.e("", "", e)
        }
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
        Handler().postDelayed({
            supportFragmentManager.beginTransaction()
                .add(R.id.container, TutorialFragment.newInstance(tutorialText))
                .commit()
        }, 500)
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        viewModel.requestEvent()
        hideVatabe()

        val currentCardImmutable = currentCard
        if (direction == Right) {
            handleRightSwipe(currentCardImmutable)
        } else {
            handleLeftSwipe(currentCardImmutable)
        }
    }

    private fun handleRightSwipe(currentCardImmutable: BaseCardLocal?) {
        if (currentCardImmutable is QuestionCardLocal) {
            money += currentCardImmutable?.question?.positiveDecisionAnswer?.moneyQty?.toInt() ?: 0
            setUserBalance(money)
            currentCardImmutable?.question?.positiveDecisionAnswer?.reply?.let {
                openTutorialFragment(it)
            }
        } else if (currentCardImmutable is EventCardLocal) {
            money += currentCardImmutable.event.moneyQty
            setUserBalance(money)
        }
    }

    private fun handleLeftSwipe(currentCardImmutable: BaseCardLocal?) {
        if (currentCardImmutable is QuestionCardLocal) {
            money += currentCardImmutable?.question?.negativeDecisionAnswer?.moneyQty?.toInt() ?: 0
            setUserBalance(money)
            currentCardImmutable?.question?.negativeDecisionAnswer?.reply?.let {
                openTutorialFragment(it)
            }
        } else if (currentCardImmutable is EventCardLocal) {
            money += currentCardImmutable.event.moneyQty
            setUserBalance(money)
        }
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {}

    override fun onCardDisappeared(view: View?, position: Int) {}
}
