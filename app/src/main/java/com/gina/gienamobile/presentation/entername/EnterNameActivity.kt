package com.gina.gienamobile.presentation.entername

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gina.gienamobile.R
import com.gina.gienamobile.databinding.ActivityEnterNameBinding
import com.gina.gienamobile.presentation.segmentation.SegmentationActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class EnterNameActivity : AppCompatActivity(R.layout.activity_enter_name) {

    private val binding: ActivityEnterNameBinding by viewBinding()
    private val viewModel: EnterNameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeViewModel()
        binding.btnNext.setOnClickListener {
            binding.etName.text.toString().let {
                if (it.isNotEmpty()) {
                    viewModel.onStartClicked(it)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        showVatabe()
    }

    private fun observeViewModel() {
        viewModel.openSelectClassActivity.observe(this) {
            startActivity(Intent(this, SegmentationActivity::class.java))
        }
    }

    private fun showVatabe() {
        binding.vatabeView.visibility = View.VISIBLE
        binding.vatabeView.setGladnessMood()
        binding.vatabeView.setSpeech(
            "Привет! \\(•◡•)/" +
                    " Я - Ватабэ, твой персональный финансовый помощник\u2028Как тебя зовут?", 16
        )
    }
}