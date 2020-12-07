package com.example.restaurants.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurants.Communicator
import com.example.restaurants.R
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel

class AddFragment : Fragment() {

    lateinit var comm:Communicator
    private lateinit var profileImage:ImageView
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)


   // mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //mUserViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

      //  mUserViewModel.readAllData().observe(viewLifecycleOwner, Observer
       //     {
        //        user ->
        //    })


    return view
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().run {
            //viewmodel
            ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

            //sav button
            val save = view.findViewById<Button>(R.id.button_save)
            save.setOnClickListener {
                insertDataToDatabase()
                findNavController().navigate(R.id.action_addFragment_to_profileFragment)

            }
        }

    }


companion object
{
    //imagePick code
    private val IMAGE_PICK_CODE = 1000;

    //permission code
    private val PERMISSION_CODE =1001;
}

private fun insertDataToDatabase() {
    profileImage = requireActivity().findViewById<ImageView>(R.id.imageView)

    profileImage.setOnClickListener {


        //check runtime permission
        //what the heck is this??

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                            requireContext(),
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_DENIED
            ) {

                val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

                //show the runtime permission

                requestPermissions(permission, PERMISSION_CODE)
            } else {
                //permission alredy garanted

                pickImageFromGalery();
            }
        } else {
            pickImageFromGalery();
        }
    }
    val un = view?.findViewById<TextView>(R.id.editName);
    val ua = view?.findViewById<TextView>(R.id.editAdress)
    val up = view?.findViewById<TextView>(R.id.editPhone)
    val ue = view?.findViewById<TextView>(R.id.editEmail)

    val UserName = un?.text.toString()
    val UserAdress = ua?.text.toString()
    val UserPhone = up?.text.toString()
    val UserEmail = ue?.text.toString()

    if(inputCheck(UserName,UserAdress,UserPhone,UserEmail))
    {
        //Creat user object
        val user = User(0,UserName,Integer.parseInt(profileImage.toString()),UserAdress,UserPhone,UserEmail)
        //Add data to database

        mUserViewModel.addUser(user)

        Toast.makeText(requireContext(),"Succesfully added!",Toast.LENGTH_LONG).show()
        //navigate back to profile fragment

        // comm.passDataCom(UserName)
       // comm.passDataCom(UserAdress)
        //comm.passDataCom(profileImage.toString())
        //comm.passDataCom(UserPhone)
       // comm.passDataCom(UserEmail)
    }else
    {
        Toast.makeText(requireContext(),"BAD!",Toast.LENGTH_LONG).show()
    }


}

private fun inputCheck(UserName:String,UserAdress:String,UserPhone:String,UserEmail:String):Boolean
{
    return !(TextUtils.isEmpty(UserName) && TextUtils.isEmpty(UserAdress) && TextUtils.isEmpty(UserPhone) && TextUtils.isEmpty(UserEmail))
}

private fun pickImageFromGalery()
{
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    startActivityForResult(intent, IMAGE_PICK_CODE)

}

override fun onActivityResult(requestCode:Int,resultCode:Int,data: Intent?) {
    if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
        //ProfileImage.setImageURI(data?.data)
    }
}

override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    when(requestCode)
    {
        PERMISSION_CODE ->
        {
            if(grantResults.size >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                //permission from popup granted
                pickImageFromGalery();
            }else
            {
                //permission from popup denied
                Toast.makeText(context,"permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
}

private fun DatabaseLoad()
{
   // userViewModel?.readAllData()?.observe(this
   // ) {
        //if (it != null) {
           // user = it
            //toggleEditMode

       // } else {
            //valami
       // }
    //}
}
}