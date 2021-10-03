package com.espresso.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DirectorsFragment : Fragment() {

    private val directors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            directors.addAll(args.get("args_directors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_directors, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDirectors()
    }

    private fun setDirectors() {
        view?.findViewById<TextView>(R.id.directors_text)?.text =
            stringBuilderForDirectors(directors)
    }

    companion object {
        fun stringBuilderForDirectors(directors: ArrayList<String>): String {
            val sb = StringBuilder()
            for (director in directors) {
                sb.append(director + "\n")
            }
            return sb.toString()
        }
    }
}

















