package com.dmi.cvbuilder.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dmi.cvbuilder.domain.User
import cvbuilder.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    var userList= arrayListOf<User>(
         User("Dennis","Ibrahim","dibrahim@miu.edu","password"),
         User("Melon","Tadesse","mtadesse@miu.edu","password"),
         User("Eric","Ayalla","eayalla@miu.edu","password"),
        User("test","test","test@nowhere.com","password")
    )
    val users= ArrayList<User>(userList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = getIntent()
        val user = intent.getSerializableExtra("user") as? User
        if(user !=null)
           users.add(user)
        loginButton.setOnClickListener{login()}

    }

 private fun login(){
     if(usernameEdt.text.isEmpty() || passwordEdt.text.isEmpty()){
         if(usernameEdt.text.isEmpty()){
             usernameEdt.requestFocus()
         }
         else{
             passwordEdt.requestFocus()
         }
         Toast.makeText(this, "Please enter all required informatiom", Toast.LENGTH_LONG).show()
         return
     }
     //Check if username exists
     val user = users.find { info -> info.getUserName().equals(usernameEdt.text.toString(), true)
             && info.getpassword().equals(passwordEdt.text.toString(),true) }
     if(user !=null){
     val intent = Intent(this, MainActivity::class.java)
         intent.putExtra("username",user.getUserName())
       startActivity(intent)
     }
     else{
         Toast.makeText(this,"Invalid username or password", Toast.LENGTH_LONG).show()
     }
 }

}