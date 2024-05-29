package com.example.practica6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddUserFragment : Fragment() {

    private lateinit var etUserName: EditText
    private lateinit var btnSaveUser: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etUserName = view.findViewById(R.id.et_user_name)
        btnSaveUser = view.findViewById(R.id.btn_save_user)

        btnSaveUser.setOnClickListener {
            val userName = etUserName.text.toString().trim()

            if (userName.isNotEmpty()) {
                val bundle = Bundle().apply {
                    putString("userName", userName)
                    putInt("userImage", R.drawable.ic_user_placeholder)
                }
                findNavController().navigate(R.id.action_addUserFragment_to_userListFragment, bundle)
            } else {
                etUserName.error = "El nombre del usuario es obligatorio"
            }
        }
    }
}