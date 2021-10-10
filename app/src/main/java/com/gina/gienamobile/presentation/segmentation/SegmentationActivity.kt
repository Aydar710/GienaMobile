package com.gina.gienamobile.presentation.segmentation

import android.content.Intent
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gina.gienamobile.R
import com.gina.gienamobile.R.drawable
import com.gina.gienamobile.databinding.ActivitySegmentationBinding
import com.gina.gienamobile.presentation.main.MainActivity

class SegmentationActivity : AppCompatActivity(R.layout.activity_segmentation) {

    private val binding: ActivitySegmentationBinding by viewBinding()
    private val classes = mutableListOf<ClassModel>()

    override fun onResume() {
        super.onResume()

        populateClasses()

        Handler().postDelayed({
            showVatabe()
        }, 150)


        setClassImages()

        setClassClickListeners()

        binding.classStudent.callOnClick()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setClassImages() {
        binding.classClerk.setClassImage(drawable.ic_clerk)
        binding.classStudent.setClassImage(drawable.ic_student)
        binding.classBusinessman.setClassImage(drawable.ic_businesman)
    }

    private fun setClassClickListeners() {
        binding.classClerk.setOnClickListener {
            binding.classClerk.markAsSelected()
            binding.classStudent.markAsUnSelected()
            binding.classBusinessman.markAsUnSelected()
            showClassInfo(1)
        }

        binding.classStudent.setOnClickListener {
            binding.classStudent.markAsSelected()
            binding.classClerk.markAsUnSelected()
            binding.classBusinessman.markAsUnSelected()
            showClassInfo(0)
        }

        binding.classBusinessman.setOnClickListener {
            binding.classBusinessman.markAsSelected()
            binding.classStudent.markAsUnSelected()
            binding.classClerk.markAsUnSelected()
            showClassInfo(2)
        }
    }

    private fun showClassInfo(index: Int) {
        binding.tvClassName.text = classes[index].name
        binding.tvClassDescription.text = classes[index].description
    }

    private fun showVatabe() {
        binding.vatabeView.visibility = View.VISIBLE
        binding.vatabeView.setGladnessMood()
        binding.vatabeView.setSpeech("Какое красивое имя! (✿◠‿◠) \u2028А чем ты занимаешься?")
    }

    private fun populateClasses() {
        classes.add(
            ClassModel(
                resources.getString(R.string.class_student),
                resources.getString(R.string.class_student_desc),
                R.drawable.ic_student
            )
        )

        classes.add(
            ClassModel(
                resources.getString(R.string.class_clerk),
                resources.getString(R.string.class_clerk_desc),
                R.drawable.ic_clerk
            )
        )

        classes.add(
            ClassModel(
                resources.getString(R.string.class_businessman),
                resources.getString(R.string.class_businessman_desc),
                R.drawable.ic_businesman
            )
        )
    }
}