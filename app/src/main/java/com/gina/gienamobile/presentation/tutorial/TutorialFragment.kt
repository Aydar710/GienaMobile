package com.gina.gienamobile.presentation.tutorial

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.gina.gienamobile.R

class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    companion object {

        private const val ARG_TUTORIAL_TEXT = "argTutorialText"
        private const val ARG_LINK = "argLink"

        fun newInstance(tutorialText: String, linkToVtb: String? = null): TutorialFragment {
            val fragment = TutorialFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_TUTORIAL_TEXT, tutorialText)
                linkToVtb?.let {
                    putString(ARG_LINK, it)
                }
            }
            return fragment
        }
    }

    private val fragmentArgs: FragmentArgs by lazy { getArgumentsFromBundle() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        view?.findViewById<TextView>(R.id.tvTutorial)?.text = fragmentArgs.tutorialText

        view?.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                ?.remove(this)
                ?.commit()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLinkIfExists()
    }

    private fun setupLinkIfExists() {
        val tvMoreInfo = view?.findViewById<TextView>(R.id.tvMoreInfo)
        fragmentArgs.link?.let { link ->
            tvMoreInfo?.isVisible = true
            tvMoreInfo?.setOnClickListener {
                openPageInLink(link)
            }
        } ?: run {
            tvMoreInfo?.isVisible = false
        }
    }

    private fun openPageInLink(link: String) {
        val uri: Uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun getArgumentsFromBundle(): FragmentArgs {
        return FragmentArgs(arguments?.getString(ARG_TUTORIAL_TEXT), arguments?.getString(ARG_LINK))
    }

    private inner class FragmentArgs(val tutorialText: String?, val link: String?)
}