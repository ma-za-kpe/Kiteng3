package com.kpe.foodaway.ui.fragment

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.kpe.foodaway.FoodStuff
import com.kpe.foodaway.R
import com.kpe.foodaway.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.email_address

class LoginFragment : BaseFragment() {

    val prefManager = FoodStuff.instance!!.preferenceManager
    private lateinit var textview : TextView
    private val start: Int? = null
    private val end: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (prefManager.isClient){
            //change color if vendor
            (activity as AppCompatActivity?)!!.supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.purple_500)))
            login_login.setBackgroundColor(resources.getColor(R.color.purple_500))
            log_in_fb.strokeColor = ColorStateList.valueOf(resources.getColor(R.color.purple_500))
            log_in_google.strokeColor = ColorStateList.valueOf(resources.getColor(R.color.purple_500))
            bluebackground.setBackgroundColor(resources.getColor(R.color.purple_500))
        } else if (prefManager.isVendor){
            //change color if vendor
            (activity as AppCompatActivity?)!!.supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.purple_700)))
            login_login.setBackgroundColor(resources.getColor(R.color.purple_700))
            log_in_fb.strokeColor = ColorStateList.valueOf(resources.getColor(R.color.purple_700))
            log_in_google.strokeColor = ColorStateList.valueOf(resources.getColor(R.color.purple_700))
            bluebackground.setBackgroundColor(resources.getColor(R.color.purple_700))
        }


        //go to signup
        login_texts_orsingup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        ui()

        //hightlihging
        //build the spannable String for 50 shillings
        val optional = resources.getString(R.string.login_text);
        hightlightText(optional, 22, 30, login_texts_orsingup, resources.getColor(R.color.purple_700))
    }

    //22 30

    private fun ui() {
        // Get input email text
        val inputemailText = email_address.editText?.text.toString()

        // Get input password text
        val inputpasswordText = password_toggle.editText?.text.toString()

//        filledTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
//            // Respond to input text change
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}