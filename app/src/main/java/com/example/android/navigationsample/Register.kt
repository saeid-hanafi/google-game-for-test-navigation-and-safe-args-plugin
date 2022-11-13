/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar


/**
 * Shows a register form (that does nothing, for simplicity)
 */
class Register : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val username = view.findViewById<EditText>(R.id.username_text)
        val email = view.findViewById<EditText>(R.id.email_text)
        val pass = view.findViewById<EditText>(R.id.password_text)

        view.findViewById<Button>(R.id.signup_btn).setOnClickListener {
            if (username.length() > 0 && email.length() > 0 && pass.length() > 0) {
                val userManager = UserManager(context)
                val userSignUp = userManager.saveSignUp(username.toString(), email.toString(), pass.toString())
                if (userSignUp)
                    findNavController().navigate(R.id.action_register_to_match)
                else
                    Snackbar.make(view, "Error on add user processing, Try again Please!", Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(view, "All Fields Is Required!", Snackbar.LENGTH_SHORT).show()
            }

        }
        return view
    }
}
