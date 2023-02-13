package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    lateinit var sm: SendMessage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Nullable
    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPassData = view.findViewById<Button>(R.id.btnPassData)
        val inData = view.findViewById<EditText>(R.id.inMessage)
        btnPassData.setOnClickListener {
            sm.sendData(inData.text.toString().trim())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            sm = context as SendMessage
        } catch (e: ClassCastException) {
            throw ClassCastException("Error retrieving data. Please try again")
        }
    }

    interface SendMessage {
        fun sendData(message: String)
    }
}
