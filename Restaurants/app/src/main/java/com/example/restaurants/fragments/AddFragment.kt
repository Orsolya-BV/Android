package com.example.restaurants.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.restaurants.MainActivity
import com.example.restaurants.R
import com.example.restaurants.data.user.User
import com.example.restaurants.data.user.UserViewModel
import java.util.regex.Pattern

class AddFragment : Fragment() {

    // lateinit var comm:Communicator
    //private lateinit var profileImage:ImageView
     private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)


       //  mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        //  mUserViewModel.readAllData().observe(viewLifecycleOwner, Observer
        //     {
        //        user ->
        //    })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //viewmodel
            // mUserViewModel= ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

            //sav button
            val save = view.findViewById<Button>(R.id.button_save)
            save.setOnClickListener {
                insertDataToDatabase()
                view.findNavController().navigate(R.id.action_listFragment_to_profileFragment)
            }


    }


    companion object {
        //imagePick code
        private val IMAGE_PICK_CODE = 1000;

        //permission code
        private val PERMISSION_CODE = 1001;
    }

    private fun insertDataToDatabase() {

        val profileImage =view?.findViewById<ImageView>(R.id.imageView2)
        val userName = view?.findViewById<TextView>(R.id.editName);
        val userAdress = view?.findViewById<TextView>(R.id.editAdress)
        val userPhone = view?.findViewById<TextView>(R.id.editPhone)
        val userEmail = view?.findViewById<TextView>(R.id.editEmail)
        val userPassword = view?.findViewById<TextView>(R.id.editpassword)

        val uName = userName?.text.toString()
        val uAdres = userAdress?.text.toString()
        val uPhone = userPhone?.text.toString()
        val uEmail = userEmail?.text.toString()
        val uPassword = userPassword?.text.toString()


        val user1 =User(0,uName,uAdres,uPhone,uEmail,uPassword)
        mUserViewModel.addUser(user1)
        mUserViewModel.userValue = user1



        //Log.d("User name",uName)
      //  Log.d("User password",uPassword)


        /*
    profileImage.setOnClickListener {


        //check runtime permission


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
    }



 */
/*
    if(inputCheck(userName,userEmail,userPhone,userAdress))
    {
        //Creat user object
     // val user = User(0, userName?.text.toString(),Integer.parseInt(profileImage.toString()),userAdress?.text.toString(),userPhone?.text.toString(),userEmail?.text.toString())

         val user = User(0,userName?.text.toString(),userAdress?.text.toString(),userPhone?.text.toString(),userEmail.text.toString())
        //Add data to database

        //mUserViewModel.addUser(user)

        Toast.makeText(requireContext(),"Succesfully added!",Toast.LENGTH_LONG).show()
        //navigate back to profile fragment


*/
        //mUserViewModel.activeUser().observe(requireActivity(),
        /*
        Observer {
            if(it !=null)
            {
                val intent = Intent(requireActivity(),MainActivity::class.java)
                intent.putExtra("id",it.user_id.toString())
                intent.putExtra("name",it.user_name)
                intent.putExtra("adress",it.user_adress)
                intent.putExtra("phone",it.user_phone_number)
              //intent.putExtra("image",it.user_image.toString())
                startActivity(intent)
                requireActivity().finish()
             //findNavController().navigate(R.id.action_addFragment_to_profileFragment)
            }
        })
    }else
    {
       Toast.makeText(requireContext(),"BAD!",Toast.LENGTH_LONG).show()
    } */
/*
        mUserViewModel.activeUser().observe(requireActivity(), Observer
                {
                    if(it != null)
                    {
                        val intent = Intent(requireActivity(),MainActivity::class.java)

                        intent.putExtra("id",it.user_id.toString())
                        intent.putExtra("name",it.user_name)
                        intent.putExtra("email",it.user_email)
                        intent.putExtra("adress",it.user_adress)
                        intent.putExtra("phone",it.user_phone_number)

                        startActivity(intent)
                        requireActivity().finish()
                    }
                    else
                    {
                        Toast.makeText(requireContext(),"Nem jo na ",Toast.LENGTH_LONG).show()
                    }
                })


 */
    }
/*
    private fun inputCheck(name: TextView, email: TextView, phone: TextView,adress:TextView): Boolean {

       // return (validateUserName(name) && validateEmail(email) && validateAdress(adress))
        return !(name.text.isEmpty() && email.text.isEmpty() && phone.text.isEmpty() && adress.text.isEmpty())

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


    private fun validatePhone(phone: TextView):Boolean
    {

      val Phone = phone.text.toString()


        if(Phone.isEmpty() )
        {
            phone.setError("Kérlek töltsd ki!")
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


 */




 }



 */
}