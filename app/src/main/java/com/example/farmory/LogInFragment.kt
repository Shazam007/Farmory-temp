package com.example.farmory

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.farmory.homeMenuTabs.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LogInFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)

        view.findViewById<TextView>(R.id.signUpHereBtn).setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
        auth = Firebase.auth

        view.findViewById<TextView>(R.id.logInBtn).setOnClickListener{
            login()
        }

        return view
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            //redirect to homepage fragment without login
            //findNavController().navigate(R.id.action_logInFragment_to_homeFragment)

            //redirect to homepage activity without login
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(){
        val userEmail = view?.findViewById<EditText>(R.id.signInEmail)
        val userPassword = view?.findViewById<EditText>(R.id.signInPassword)

        if (userEmail?.text.toString().isEmpty()){
            userEmail?.error = "Please Enter Email"
            userEmail?.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail?.text.toString()).matches()){
            userEmail?.error = "Please Enter Valid Email"
            userEmail?.requestFocus()
            return
        }
        if(userPassword?.text.toString().isEmpty()){
            userPassword?.error = "Please Enter Password"
            userPassword?.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(userEmail?.text.toString(), userPassword?.text.toString())
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    //findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                    //direct to homepage activity after login
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireActivity(), "Login failed.",Toast.LENGTH_SHORT).show()
                }
            }
    }
}