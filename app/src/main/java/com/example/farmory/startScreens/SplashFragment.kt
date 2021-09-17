package com.example.farmory.startScreens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmory.R
import com.example.farmory.homeMenuTabs.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = Firebase.auth

        Handler().postDelayed({

            if(onBoardFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_logInFragment)

                //use below code to hide sudden login screen popup
                //val currentUser = auth.currentUser
                //if(currentUser != null){
                //    val intent = Intent(activity, HomeActivity::class.java)
                //    startActivity(intent)
                //}else{
                //    findNavController().navigate(R.id.action_splashFragment_to_logInFragment)
                //}
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }


        },3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardFinished():Boolean{
        val sharedPref  =requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

}