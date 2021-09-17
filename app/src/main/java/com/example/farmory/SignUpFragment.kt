package com.example.farmory

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        view.findViewById<TextView>(R.id.signInHereBtn).setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }
        auth = Firebase.auth

        view.findViewById<Button>(R.id.signUpBtn).setOnClickListener{
            signUpUser()
        }
        return view
    }

    private fun signUpUser(){
        val userEmail = view?.findViewById<EditText>(R.id.signUpEmail)
        val userPassword = view?.findViewById<EditText>(R.id.signUpPassword)
        val userRePassword = view?.findViewById<EditText>(R.id.signUpRePassword)

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

        if(userPassword?.text.toString().length<6){
            userPassword?.error = "Password need to at least six characters"
            userPassword?.requestFocus()
            return
        }
        if(userRePassword?.text.toString() != userPassword?.text.toString()){
            userRePassword?.error = "Passwords are not matching"
            userRePassword?.requestFocus()
            return
        }

        if(userRePassword?.text.toString().isEmpty()){
            userRePassword?.error = "Please Retype Password"
            userRePassword?.requestFocus()
            return
        }



        auth.createUserWithEmailAndPassword(userEmail?.text.toString(), userPassword?.text.toString())
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
                    val user = auth.currentUser
                } else {
                    Toast.makeText(requireActivity(), "Authentication failed.",Toast.LENGTH_SHORT).show()
                }
            }
    }
}



