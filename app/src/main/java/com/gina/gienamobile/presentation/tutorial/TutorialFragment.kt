package com.gina.gienamobile.presentation.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gina.gienamobile.R

class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    companion object {

        private const val ARG_TUTORIAL_TEXT = "argTutorialText"

        fun newInstance(tutorialText: String): TutorialFragment {
            val fragment = TutorialFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_TUTORIAL_TEXT, tutorialText)
            }
            return fragment
        }
    }

    private val fragmentArgs: FragmentArgs by lazy { getArgumentsFromBundle() }
    private val tvTutorial: TextView? by lazy { view?.findViewById(R.id.tvTutorial) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        view?.findViewById<TextView>(R.id.tvTutorial)?.text = "${fragmentArgs.tutorialText} "
        return view
    }

    private fun setTutorialText() {
        fragmentArgs.tutorialText?.let {
            tvTutorial?.text = it
        }
    }

    private fun getArgumentsFromBundle(): FragmentArgs {
        return FragmentArgs(arguments?.getString(ARG_TUTORIAL_TEXT))
    }

    private inner class FragmentArgs(val tutorialText: String?)
}