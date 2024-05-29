package com.example.practica6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        userAdapter = UserAdapter(userList) { user ->
            // Handle item click
        }
        recyclerView.adapter = userAdapter

        val fabAddUser: FloatingActionButton = view.findViewById(R.id.fab_add_user)
        fabAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_addUserFragment)
        }

        // Manejar el argumento enviado desde AddUserFragment
        val bundle = arguments
        if (bundle != null) {
            val userName = bundle.getString("userName")
            val userImage = bundle.getInt("userImage")
            if (userName != null && userImage != 0) {
                val newUser = User(userName, userImage)
                userList.add(newUser)
                userAdapter.notifyDataSetChanged()
            }
        }
    }
}