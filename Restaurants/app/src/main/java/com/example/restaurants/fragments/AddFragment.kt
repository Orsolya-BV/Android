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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurants.Communicator
import com.example.restaurants.MainActivity
import com.example.restaurants.R
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel
import java.util.regex.Pattern

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
    val userName = requireView().findViewById<TextView>(R.id.editName);
    val userAdress = requireView().findViewById<TextView>(R.id.editAdress)
    val userPhone = requireView().findViewById<TextView>(R.id.editPhone)
    val userEmail = requireView().findViewById<TextView>(R.id.editEmail)



    if(inputCheck(userName,userEmail,userPhone,userAdress))
    {
        //Creat user object
        val user = User(0, userName?.text.toString(),Integer.parseInt(profileImage.toString()),userAdress?.text.toString(),userPhone?.text.toString(),userEmail?.text.toString())
        //Add data to database

        mUserViewModel.addUser(user)

        Toast.makeText(requireContext(),"Succesfully added!",Toast.LENGTH_LONG).show()
        //navigate back to profile fragment

        // comm.passDataCom(UserName)
       // comm.passDataCom(UserAdress)
        //comm.passDataCom(profileImage.toString())
        //comm.passDataCom(UserPhone)
       // comm.passDataCom(UserEmail)

       // mUserViewModel.activeUser().observe(requireActivity(),
       // Observer {
         //   if(it !=null)
         //   {
                //val intent = Intent(requireActivity(),MainActivity::class.java)
                //intent.putExtra("id",it.user_id.toString())
                //intent.putExtra("name",it.user_name)
                //intent.putExtra("adress",it.user_adress)
               // intent.putExtra("phone",it.user_phone_number)
               // intent.putExtra("image",it.user_image.toString())
                //startActivity(intent)
          //      findNavController().navigate(R.id.action_addFragment_to_profileFragment)
           // }
       // })
   // }else
   // {
    //    Toast.makeText(requireContext(),"BAD!",Toast.LENGTH_LONG).show()
    }


}



    private fun inputCheck(name: TextView, email: TextView, phone: TextView,adress:TextView): Boolean {

        return (validateUserName(name) && validateEmail(email) && validatePhone(phone) && validateAdress(adress))

    }
    private fun validateUserName(name:TextView):Boolean
    {

        val nameT =name.text.toString()

        if(nameT.isEmpty())
        {
            name.setError("Kérlek töltsd ki!")
            return false

        }
        else if(!Pattern.compile("^(?!.*\\.\\.)(?!.*\\.\$)[^\\W][\\w.]{0,29}\$").matcher(nameT).matches())
        {
            name.setError("Érvénytelen felhasználónév!")
            return false
        }else
        {
            name.setError(null)
            return true
        }
    }

    private fun validateEmail(email:TextView):Boolean
    {
        val emailT = email.text.toString()

        if(emailT.isEmpty())
        {
            email.setError("Kérlek töltsd ki!")
            return false
        }else if(!Pattern.compile("^[a-zA-Z0-9_.%+-]+@[a-zA-Z0-9_.%+-]+.[a-z]{2,}\$").matcher(emailT).matches())
        {
            email.setError("Érvénytelen email-cím!")
            return false
        }else
        {
            email.setError(null)
            return true
        }
    }

    @Suppress("UNREACHABLE_CODE")
    private fun validatePhone(phone: TextView):Boolean
    {

      val Phone = phone.text.toString()


        if(Phone.isEmpty() )
        {
            phone.setError("Kérlek töltsd ki!")
            return false
        }
        else if(!Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$").matcher(Phone).matches())
        {
            phone.setError("Helytelen jelszó!")
            return false
        }
        else
        {
            return true
        }
    }

    private fun validateAdress(adress: TextView):Boolean
    {
        val Adress = adress.text.toString()

        if(Adress.isEmpty())
        {
            adress.setError("Kérlek töltsd ki!")
            return false

        }
        else if(!Pattern.compile("^(?!.*\\.\\.)(?!.*\\.\$)[^\\W][\\w.]{0,29}\$").matcher(Adress).matches())
        {
           adress.setError("Érvénytelen felhasználónév!")
            return false
        }else
        {
            adress.setError(null)
            return true
        }
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