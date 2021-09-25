package com.example.farmory.startScreens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.farmory.R


class PromotionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_promotion, container, false)

        view.findViewById<ImageButton>(R.id.cat_1).setOnClickListener{
            val clipboardManager = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", "KQ4OL9V")
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(requireContext(), "KQ4OL9V copied to clipboard", Toast.LENGTH_LONG).show()
        }

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener{
            findNavController().navigate(R.id.action_promotionFragment_to_menuHomeFragment)
        }



        return view;
    }
}