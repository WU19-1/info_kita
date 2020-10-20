package com.entre.infokita

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_startup.*

class StartupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        sign_in_password.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_DONE){
                    sign_in_password.clearFocus()
                    (applicationContext.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(sign_in_password.rootView.windowToken,0)
                    return true
                }
                return false
            }
        })

        sign_in_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(sign_in_username.text.toString().equals("admin") && sign_in_password.text.toString().equals("admin")){
                    var i = Intent(this@StartupActivity,MainActivity::class.java)
                    startActivity(i)
                    Toast.makeText(this@StartupActivity,"Login successful",Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}
